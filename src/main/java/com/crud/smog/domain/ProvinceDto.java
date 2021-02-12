package com.crud.smog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceDto {
    private Long id;
    private String provinceName;
    private double centralLongitude;
    private double centralLatitude;
    private double longitudeNW;
    private double latitudeNW;
    private double longitudeNE;
    private double latitudeNE;
    private double longitudeSE;
    private double latitudeSE;
    private double longitudeSW;
    private double latitudeSW;
}
