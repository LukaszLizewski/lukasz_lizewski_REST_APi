package com.crud.smog.google.service;

import com.crud.smog.air.client.AirClient;
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

import java.util.List;
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
    }


    private List<AirStation> getFilteredStations(List<AirStation> list, double latitudeMax, double latitudeMin, double longitudeMax, double longitudeMin) {
        return list.stream()
                .filter(e -> e.getGegrLat() >= latitudeMax && e.getGegrLat() <= latitudeMin)
                .filter(e -> e.getGegrLon() >= longitudeMax && e.getGegrLon() <= longitudeMin)
                .collect(Collectors.toList());
    }
}
