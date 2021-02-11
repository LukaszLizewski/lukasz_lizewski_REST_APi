package com.crud.smog.controller;

import com.crud.smog.domain.UserEntity;
import com.crud.smog.google.client.GoogleClient;
import com.crud.smog.google.config.GoogleConfig;
import com.crud.smog.repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/map")
    public URL getMapForUser() throws MalformedURLException {
        UserEntity result = userRepository.retrieveUserById(33L);
        System.out.println(result.getAddressProvince());
        return new URL (googleClient.getUserUrl());
    }
}
