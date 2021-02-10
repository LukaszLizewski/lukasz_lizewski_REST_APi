package com.crud.smog.controller;

import com.crud.smog.air.service.AirService;
import com.crud.smog.domain.AirStationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
