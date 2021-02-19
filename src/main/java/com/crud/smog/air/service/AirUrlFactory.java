package com.crud.smog.air.service;

import com.crud.smog.air.config.AirConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class AirUrlFactory {
    @Autowired
    private AirConfig airConfig;

    public URI getUrlFindAll() {
        return UriComponentsBuilder.fromHttpUrl(airConfig.getAirApiEndpointStation() + "/findAll")
                .build().encode().toUri();
    }
    public URI getIndex(Long stationId) {
        return UriComponentsBuilder.fromHttpUrl(airConfig.getAirApiEndpointAqindex() + "/getIndex/" +stationId)
                .build().encode().toUri();
    }
}
