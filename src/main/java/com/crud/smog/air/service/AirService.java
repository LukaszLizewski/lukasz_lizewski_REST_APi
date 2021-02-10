package com.crud.smog.air.service;

import com.crud.smog.air.client.AirClient;
import com.crud.smog.domain.AirStation;
import com.crud.smog.domain.AirStationDto;
import com.crud.smog.mapper.AirMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AirService {
    @Autowired
    private AirClient airClient;
    @Autowired
    private AirMapper airMapper;

    public List<AirStationDto> getStations() {
        List<AirStation> list = airMapper.mapToListAirStation(airClient.getStations());
        List<AirStation> filteredList = list.stream()
                .filter(e->e.getId().intValue()>=100 && e.getId().intValue()<=200)
                .collect(Collectors.toList());
        return airMapper.mapToListAirStationDto(filteredList);
    }
}
