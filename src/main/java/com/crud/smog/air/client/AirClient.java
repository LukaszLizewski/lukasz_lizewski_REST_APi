package com.crud.smog.air.client;

import com.crud.smog.air.config.AirConfig;
import com.crud.smog.domain.AirStationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class AirClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(AirClient.class);
    @Autowired
    private AirConfig airConfig;
    @Autowired
    private RestTemplate restTemplate;

    public List<AirStationDto> getStations() {
        URI url = getUrl();
        try {
            Optional<AirStationDto[]> listResponse = Optional.ofNullable(restTemplate.getForObject(url, AirStationDto[].class));
            return Arrays.asList(listResponse.orElse(new AirStationDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }
    private URI getUrl() {
        return UriComponentsBuilder.fromHttpUrl(airConfig.getAirApiEndpointStation() + "/findAll")
                .build().encode().toUri();
    }
}
