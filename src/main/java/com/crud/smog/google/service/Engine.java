package com.crud.smog.google.service;

import com.crud.smog.air.client.AirClient;
import com.crud.smog.air.domain.AirIndex;
import com.crud.smog.air.domain.AirStation;
import com.crud.smog.air.domain.AirStationDto;
import com.crud.smog.air.service.AirService;
import com.crud.smog.domain.ProvinceEntity;
import com.crud.smog.domain.UserEntity;
import com.crud.smog.mapper.AirMapper;
import com.crud.smog.repository.ProvinceRepository;
import com.crud.smog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Engine {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private ProvinceRegion provinceRegion;
    @Autowired
    private AirService airService;
    @Autowired
    private AirMapper airMapper;
    @Autowired
    private AirClient airClient;

    protected UserEntity getUserEntity(Long userId) {
        return userRepository.retrieveUserById(userId);
    }

    private ProvinceEntity getProvinceEntity(String provinceName) {
        return provinceRepository.retrieveProvinceByName(provinceName);
    }

    protected String getProvinceCenter(String provinceName) {
        ProvinceEntity province = getProvinceEntity(provinceName);
        String resultLat = String.valueOf(province.getCentralLatitude());
        String resultLon = String.valueOf(province.getCentralLongitude());
        return resultLat + "," + resultLon;
    }

    protected void engine(String provinceName) {
        ProvinceEntity province = getProvinceEntity(provinceName);
        List<AirStation> list = airMapper.mapToListAirStation(airClient.getStations());
        List<AirStation> filteredList = getFilteredStations(list, province.getLatitudeNW(), province.getLatitudeSW(), province.getLongitudeSE(), province.getLongitudeSW());

        System.out.println(">>>lista stacji przed filtracją>>>"+ list.size());
        System.out.println(">>>ograniczniki>>>"+province.getLatitudeNW() +" "+ province.getLatitudeSW()+" "+ province.getLongitudeSE()+" "+ province.getLongitudeSW());
        System.out.println(">>>lista stacji po filtracją>>>"+filteredList.size());

        Map<AirStation, AirIndex> map = new HashMap<>();
        for (AirStation station: filteredList) {
            map.put(station,airMapper.mapToAirIndex(airClient.getIndex(station.getId())));
        }
        for (Map.Entry<AirStation, AirIndex> entry : map.entrySet()){
            System.out.println(entry.getKey().getId());
            System.out.println(entry.getValue().getStIndexLevel().getIndexLevelName());
            System.out.println(entry.getKey().getStationName());

        }
        double centerH = 50.0;
        double centerV = 35.0;
        double ramie = 5;

        double [][] table = new double [8][2];
        for (int i=0; i<8; i++){
            table[i][0]= Math.cos((i*45.0+22.5)/180*Math.PI)*ramie+centerH;
            table[i][1]= Math.sin((i*45.0+22.5)/180*Math.PI)*ramie+centerV;
            System.out.println("table [" + i + "][0]" +table[i][0]);
            System.out.println("table [" + i + "][1]"+table[i][1]);
        }

    }


    private List<AirStation> getFilteredStations(List<AirStation> list, double latitudeMax, double latitudeMin, double longitudeMax, double longitudeMin) {
        return list.stream()
                .filter(e -> e.getGegrLat() >= latitudeMin && e.getGegrLat() <= latitudeMax)
                .filter(e -> e.getGegrLon() >= longitudeMin && e.getGegrLon() <= longitudeMax)
                .collect(Collectors.toList());
    }
}
