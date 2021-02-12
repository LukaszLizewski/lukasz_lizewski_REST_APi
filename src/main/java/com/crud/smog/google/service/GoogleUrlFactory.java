package com.crud.smog.google.service;

import com.crud.smog.google.config.GoogleConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class GoogleUrlFactory {
    @Autowired
    private Engine engine;
    @Autowired
    private GoogleConfig googleConfig;

    private static final int ZOOM = 8;
    private static final int SCALE = 2;
    private static final String SIZE = "1000x500";

    public URI getUserUrl(Long userId) {

        return UriComponentsBuilder.fromHttpUrl(googleConfig.getGoogleApiEndpoint())
                .queryParam("key", googleConfig.getGoogleApiKey())
                .queryParam("center", engine.getProvinceCenter(engine.getUserEntity(userId).getAddressProvince()))
                .queryParam("zoom", ZOOM)
                .queryParam("size", SIZE)
                .queryParam("scale", SCALE)
                .query(engine.createOctagonsUrl(engine.getUserEntity(userId).getAddressProvince()))
                .build().encode().toUri();
    }


}
