package com.crud.smog.controller;

import com.crud.smog.air.service.AirService;
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
    private AirService airService;

    @RequestMapping(method = RequestMethod.GET, value = "/station")
    public List<AirStationDto> getStations() {
        return airService.getStations();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/station/{stationId}")
    public AirIndexDto getStations(@PathVariable("stationId") Long stationId) throws AirNotFoundException {
        return airService.getIndex(stationId);
    }
}
