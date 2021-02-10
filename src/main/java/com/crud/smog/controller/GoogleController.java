package com.crud.smog.controller;

import com.crud.smog.google.client.GoogleClient;
import com.crud.smog.google.config.GoogleConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/smog")
public class GoogleController {

    @Autowired
    private GoogleClient googleClient;

    @RequestMapping(method = RequestMethod.GET, value = "/map")
    public URL getMapForUser() throws MalformedURLException {

        return new URL (googleClient.getUrl());

    }
}
