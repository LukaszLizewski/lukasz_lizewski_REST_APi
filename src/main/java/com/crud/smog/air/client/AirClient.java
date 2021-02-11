package com.crud.smog.air.client;

import com.crud.smog.air.service.UrlFactory;
import com.crud.smog.air.domain.AirIndexDto;
import com.crud.smog.air.domain.AirStationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class AirClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(AirClient.class);
    @Autowired
    private UrlFactory urlFactory;
    @Autowired
    private RestTemplate restTemplate;

    public List<AirStationDto> getStations() {
        try {
            Optional<AirStationDto[]> listResponse = Optional.ofNullable(restTemplate.getForObject(urlFactory.getUrlFindAll(), AirStationDto[].class));
            return Arrays.asList(listResponse.orElse(new AirStationDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    public AirIndexDto getIndex(Long stationId) {
        try {
            Optional<AirIndexDto> response = Optional.ofNullable(restTemplate.getForObject(urlFactory.getIndex(stationId), AirIndexDto.class));
            return response.orElse(new AirIndexDto());
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new AirIndexDto();
        }
    }
}
