package com.crud.smog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AirStation {
    private Long id;
    private String stationName;
    private double gegrLat;
    private double gegrLon;
}
