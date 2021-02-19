package com.crud.smog.google.service;

import com.crud.smog.air.client.AirClient;
import com.crud.smog.air.domain.AirIndex;
import com.crud.smog.air.domain.AirStation;
import com.crud.smog.controller.UserNotFoundException;
import com.crud.smog.domain.ProvinceEntity;
import com.crud.smog.domain.UserEntity;
import com.crud.smog.mapper.AirMapper;
import com.crud.smog.repository.ProvinceRepository;
import com.crud.smog.repository.UserRepository;
import com.crud.smog.service.DbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class EngineUrl {
    @Autowired
    private DbUserService userRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private AirMapper airMapper;
    @Autowired
    private AirClient airClient;

    private static final String INDEX_0_COLOR= "0x00CCFF";
    private static final String INDEX_1_COLOR= "0x00FF33";
    private static final String INDEX_2_COLOR= "0xCCFF00";
    private static final String INDEX_3_COLOR= "0xFF9900";
    private static final String INDEX_4_COLOR= "0xFF0033";
    private static final String INDEX_5_COLOR= "0x6633CC";
    private static final String INDEX_6_COLOR= "0x999999";
    private static final String MARKER_COLOR= "black";
    private static final double RADIUS= 0.15;

    protected UserEntity getUserEntity(Long userId) throws UserNotFoundException  {
        return userRepository.getUser(userId).orElseThrow(UserNotFoundException::new);
    }

    private ProvinceEntity getProvinceEntity(String provinceName) {
        return provinceRepository.retrieveProvinceByName(provinceName);
    }
    protected String getUserMarker(Long userId) throws UserNotFoundException {
        UserEntity userEntity = getUserEntity(userId);
        return "&markers=color:"+MARKER_COLOR+"|size:tiny|"+userEntity.getAddressCity();
    }

    protected String getProvinceCenter(String provinceName) {
        ProvinceEntity province = getProvinceEntity(provinceName);
        String resultLat = String.valueOf(province.getCentralLatitude());
        String resultLon = String.valueOf(province.getCentralLongitude());
        return resultLat + "," + resultLon;
    }

    protected String createOctagonsUrl(String provinceName) {
        ProvinceEntity province = getProvinceEntity(provinceName);
        List<AirStation> list = airMapper.mapToListAirStation(airClient.getStations());
        System.out.println("list: "+list.size());
        List<AirStation> filteredList = getFilteredStations(list, province.getLatitudeNW(), province.getLatitudeSW(), province.getLongitudeSE(), province.getLongitudeSW());
        System.out.println("filtered list: "+filteredList.size());
        Map<AirStation, AirIndex> map = new HashMap<>();
        for (AirStation station: filteredList) {
            map.put(station,airMapper.mapToAirIndex(airClient.getIndex(station.getId())));
        }
        StringBuilder resultUrl= new StringBuilder();

        double [][] pointsTable = new double [9][2];
        double centerLat;
        double centerLon;
        int indexNo;

        for (Map.Entry<AirStation, AirIndex> entryUrl : map.entrySet()){
            indexNo = Math.toIntExact(entryUrl.getValue().getStIndexLevel().getId());
            centerLat = entryUrl.getKey().getGegrLat();
            centerLon = entryUrl.getKey().getGegrLon();
            resultUrl.append("&path=color:0x999999|weight:2|fillcolor:").append(addColorByIndex(indexNo));

            for (int i=0; i<9; i++){
                pointsTable[i][0]= Math.cos((i*45.0+22.5)/180*Math.PI)*RADIUS+centerLon;
                pointsTable[i][1]= Math.sin((i*45.0+22.5)/180*Math.PI)*RADIUS*0.55+centerLat;
                resultUrl.append("|").append(pointsTable[i][1]).append(",").append(pointsTable[i][0]);
            }
        }
        return resultUrl.toString();
    }
    private String addColorByIndex(int indexNo) {
        String colorResultUrl="";
        switch (indexNo) {
            case 0:
                colorResultUrl=INDEX_0_COLOR;
                break;
            case 1:
                colorResultUrl=INDEX_1_COLOR;
                break;
            case 2:
                colorResultUrl=INDEX_2_COLOR;
                break;
            case 3:
                colorResultUrl=INDEX_3_COLOR;
                break;
            case 4:
                colorResultUrl=INDEX_4_COLOR;
                break;
            case 5:
                colorResultUrl=INDEX_5_COLOR;
                break;
            default:
                colorResultUrl=INDEX_6_COLOR;
        }
        return colorResultUrl;
    }
    private List<AirStation> getFilteredStations(List<AirStation> list, double latitudeMax, double latitudeMin, double longitudeMax, double longitudeMin) {
        return list.stream()
                .filter(e -> e.getGegrLat() >= latitudeMin && e.getGegrLat() <= latitudeMax)
                .filter(e -> e.getGegrLon() >= longitudeMin && e.getGegrLon() <= longitudeMax)
                .collect(Collectors.toList());
    }
}
