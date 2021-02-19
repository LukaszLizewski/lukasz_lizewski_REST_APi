package com.crud.smog.google.service;

import com.crud.smog.controller.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
@Component
public class GoogleFacade {
    @Autowired
    private GoogleUrlFactory googleUrlFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleFacade.class);

    public URI getUserUrl(Long userId) throws UserNotFoundException {
        try {
            LOGGER.info("Creating the smog map for user");
            return googleUrlFactory.getUserUrl(userId);
        } catch (UserNotFoundException e) {
            LOGGER.error(UserNotFoundException.ERR_USER_NOT_FOUND);
            throw new UserNotFoundException();
        }
    }
}
