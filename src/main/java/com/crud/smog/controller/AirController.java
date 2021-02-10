package com.crud.smog.controller;

import com.crud.smog.air.client.AirClient;
import com.crud.smog.domain.AirStationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
}
