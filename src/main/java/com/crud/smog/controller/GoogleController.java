package com.crud.smog.controller;

import com.crud.smog.domain.UserEntity;
import com.crud.smog.google.client.GoogleClient;
import com.crud.smog.google.config.GoogleConfig;
import com.crud.smog.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/smog")
public class GoogleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleController.class);

    @Autowired
    private GoogleClient googleClient;


    @RequestMapping(method = RequestMethod.GET, value = "/map/{userId}")
    public URL getMapForUser(@PathVariable("userId") Long userId) throws MalformedURLException {
        LOGGER.info("GoogleController -> getMapForUser; user's Id:" + userId);


        return new URL (googleClient.getUserUrl(userId));
    }
}
