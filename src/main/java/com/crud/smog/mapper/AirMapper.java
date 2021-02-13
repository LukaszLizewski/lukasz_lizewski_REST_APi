package com.crud.smog.mapper;

import com.crud.smog.air.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class AirMapper {
    public List<AirStation> mapToListAirStation (List<AirStationDto> stationsList ) {
        return stationsList.stream()
                .map(e-> new AirStation(e.getId(),
                        e.getStationName(),
                        e.getGegrLat(),
                        e.getGegrLon()))
                .collect(Collectors.toList());
    }
    public AirIndex mapToAirIndex (AirIndexDto airIndexDto) {
        return new AirIndex(airIndexDto.getId(),new AirStationIndex(airIndexDto.getStIndexLevel().getId(),airIndexDto.getStIndexLevel().getIndexLevelName()));
    }
}
