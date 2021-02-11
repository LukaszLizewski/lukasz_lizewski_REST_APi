package com.crud.smog.google.service;

import com.crud.smog.air.domain.AirStation;
import com.crud.smog.air.service.AirService;
import com.crud.smog.domain.ProvinceEntity;
import com.crud.smog.domain.UserEntity;
import com.crud.smog.google.config.GoogleConfig;
import com.crud.smog.mapper.AirMapper;
import com.crud.smog.repository.ProvinceRepository;
import com.crud.smog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Component
public class GoogleUrlFactory {
    @Autowired
    private Engine engine;
    @Autowired
    private GoogleConfig googleConfig;

    private static final int ZOOM = 8;
    private static final int SCALE = 2;
    private static final String SIZE = "1000x400";

    public URI getUserUrl(Long userId) {
        engine.engine(engine.getUserEntity(userId).getAddressProvince());
        return UriComponentsBuilder.fromHttpUrl(googleConfig.getGoogleApiEndpoint())
                .queryParam("key", googleConfig.getGoogleApiKey())
                .queryParam("center", engine.getProvinceCenter(engine.getUserEntity(userId).getAddressProvince()))
                .queryParam("zoom", ZOOM)
                .queryParam("size", SIZE)
                .queryParam("scale", SCALE)
                .build().encode().toUri();
    }


}
