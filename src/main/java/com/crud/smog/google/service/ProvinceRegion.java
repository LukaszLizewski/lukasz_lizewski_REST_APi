package com.crud.smog.google.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ProvinceRegion {

    private Long id;
    private double longitudeNW;
    private double latitudeNW;
    private double longitudeNE;
    private double latitudeNE;
    private double longitudeSE;
    private double latitudeSE;
    private double longitudeSW;
    private double latitudeSW;
}
