package com.crud.smog.google.service;

import com.crud.smog.domain.ProvinceEntity;
import com.crud.smog.domain.UserEntity;
import com.crud.smog.google.config.GoogleConfig;
import com.crud.smog.repository.ProvinceRepository;
import com.crud.smog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class GoogleUrlFactory {
    @Autowired
    private GoogleConfig googleConfig;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProvinceRepository provinceRepository;

    private static final int ZOOM = 8;
    private static final int SCALE = 2;
    private static final String SIZE = "1000x400";

    public URI getUserUrl(Long userId) {
        return UriComponentsBuilder.fromHttpUrl(googleConfig.getGoogleApiEndpoint())
                .queryParam("key", googleConfig.getGoogleApiKey())
                .queryParam("center", getProvinceCenter(getUserEntity(userId).getAddressProvince()))
                .queryParam("zoom", ZOOM)
                .queryParam("size", SIZE)
                .queryParam("scale", SCALE)
                .build().encode().toUri();

    }
    private UserEntity getUserEntity(Long userId) {
        return userRepository.retrieveUserById(userId);
    }
    private String getProvinceCenter (String provinceName) {
        ProvinceEntity result = provinceRepository.retrieveProvinceByName(provinceName);
        String resultLat = String.valueOf(result.getCentralLatitude());
        String resultLon = String.valueOf(result.getCentralLongitude());
        return resultLat + "," + resultLon;
    }

}
