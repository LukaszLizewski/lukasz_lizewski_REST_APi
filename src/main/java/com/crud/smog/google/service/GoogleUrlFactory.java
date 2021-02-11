package com.crud.smog.google.service;

import com.crud.smog.google.config.GoogleConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class GoogleUrlFactory {
    @Autowired
    private GoogleConfig googleConfig;

    private static final String CENTER = "Batorego Gdańsk";
    private static final int ZOOM = 16;
    private static final String SIZE = "500x500";
    public URI getUserUrl() {
        return UriComponentsBuilder.fromHttpUrl(googleConfig.getGoogleApiEndpoint())
                .queryParam("key", googleConfig.getGoogleApiKey())
                .queryParam("center", CENTER)
                .queryParam("zoom", ZOOM)
                .queryParam("size", SIZE)
                .build().encode().toUri();

    }
}
