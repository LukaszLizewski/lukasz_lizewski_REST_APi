package com.crud.smog.mapper;

import com.crud.smog.domain.AirStation;
import com.crud.smog.domain.AirStationDto;

import java.util.List;
import java.util.stream.Collectors;

public class AirMapper {
    public List<AirStation> mapToListAirStation (List<AirStationDto> stationsList ) {
        return stationsList.stream()
                .map(e-> new AirStation(e.getId(),
                        e.getStationName(),
                        e.getGegrLat(),
                        e.getGegrLon()))
                .collect(Collectors.toList());
    }
    public List<AirStationDto> mapToListAirStationDto (List<AirStation> stationsList ) {
        return stationsList.stream()
                .map(e -> new AirStationDto(e.getId(),
                        e.getStationName(),
                        e.getGegrLat(),
                        e.getGegrLon()))
                .collect(Collectors.toList());
    }
}
