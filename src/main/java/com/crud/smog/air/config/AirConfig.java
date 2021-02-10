package com.crud.smog.air.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AirConfig {
    @Value("${air.api.endpoint.station}")
    private String airApiEndpointStation;
    @Value("${air.api.endpoint.data}")
    private String airApiEndpointData;
    @Value("${air.api.endpoint.aqindex}")
    private String airApiEndpointAqindex;

}
