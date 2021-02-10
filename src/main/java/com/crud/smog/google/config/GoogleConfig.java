package com.crud.smog.google.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Getter
@Component
public class GoogleConfig {
    @Value("${google.api.key}")
    private String googleApiKey;
    @Value("${google.api.endpoint}")
    private String googleApiEndpoint;
}
