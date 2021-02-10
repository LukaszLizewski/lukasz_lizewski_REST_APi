package com.crud.smog.google.client;

import com.crud.smog.google.config.GoogleConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoogleClient {
    private static final String TEMP_URL = "?center=Gdańsk%20StadionEnergaGda&zoom=15&size=400x400&key=";
    @Autowired
    private GoogleConfig googleConfig;

    public String getUrl() {
        return googleConfig.getGoogleApiEndpoint()+TEMP_URL+googleConfig.getGoogleApiKey();
    }
}
