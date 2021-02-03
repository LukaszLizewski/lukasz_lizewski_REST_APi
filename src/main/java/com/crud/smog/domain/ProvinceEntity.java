package com.crud.smog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "PROVINCE")
public class ProvinceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PROVINCE_NAME", nullable = false)
    private String provinceName;

    @Column(name = "PROVINCE_LONGITUDE", nullable = false)
    private double centralLongitude;

    @Column(name = "PROVINCE_LATITUDE", nullable = false)
    private double centralLatitude;

    @Column(name = "PROVINCE_LONGITUDE_NW", nullable = false)
    private double longitudeNW;

    @Column(name = "PROVINCE_LATITUDE_NW", nullable = false)
    private double latitudeNW;

    @Column(name = "PROVINCE_LONGITUDE_NE", nullable = false)
    private double longitudeNE;

    @Column(name = "PROVINCE_LATITUDE_NE", nullable = false)
    private double latitudeNE;

    @Column(name = "PROVINCE_LONGITUDE_SE", nullable = false)
    private double longitudeSE;

    @Column(name = "PROVINCE_LATITUDE_SE", nullable = false)
    private double latitudeSE;

    @Column(name = "PROVINCE_LONGITUDE_SW", nullable = false)
    private double longitudeSW;

    @Column(name = "PROVINCE_LATITUDE_SW", nullable = false)
    private double latitudeSW;
}
