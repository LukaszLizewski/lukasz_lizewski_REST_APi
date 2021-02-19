package com.crud.smog.google.client;

import com.crud.smog.controller.UserNotFoundException;
import com.crud.smog.google.service.GoogleFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoogleClient {
    @Autowired
    private GoogleFacade googleFacade;
    public String getUserUrl(Long userId) throws UserNotFoundException {
        return googleFacade.getUserUrl(userId).toString();
    }
}
