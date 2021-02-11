package com.crud.smog.google.client;

import com.crud.smog.google.service.GoogleUrlFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoogleClient {
    @Autowired
    private GoogleUrlFactory googleUrlFactory;
    public String getUserUrl() {
        return googleUrlFactory.getUserUrl().toString();
    }
}
