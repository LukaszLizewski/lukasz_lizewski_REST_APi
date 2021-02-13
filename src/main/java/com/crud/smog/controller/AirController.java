package com.crud.smog.controller;

import com.crud.smog.air.client.AirClient;
import com.crud.smog.air.domain.AirIndexDto;
import com.crud.smog.air.domain.AirStationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/smog")
public class AirController {

    @Autowired
    private AirClient airClient;

    @RequestMapping(method = RequestMethod.GET, value = "/station")
    public List<AirStationDto> getStations() {
        return airClient.getStations();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/station/{stationId}")
    public AirIndexDto getStations(@PathVariable("stationId") Long stationId) throws AirNotFoundException {
        return airClient.getIndex(stationId);
    }
}
