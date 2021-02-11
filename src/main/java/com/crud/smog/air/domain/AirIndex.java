package com.crud.smog.air.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AirIndex {
    private Long id;
    private AirStationIndexDto stIndexLevel;
}
