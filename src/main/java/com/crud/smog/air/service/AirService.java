package com.crud.smog.air.service;

import com.crud.smog.air.client.AirClient;
import com.crud.smog.air.domain.AirIndexDto;
import com.crud.smog.air.domain.AirStationDto;
import com.crud.smog.mapper.AirMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirService {
    @Autowired
    private AirClient airClient;
    @Autowired
    private AirMapper airMapper;

    public List<AirStationDto> getAllStations() {
        return airClient.getStations();
    }

    public AirIndexDto getIndex(Long stationId) {
        return airClient.getIndex(stationId);
    }
}
