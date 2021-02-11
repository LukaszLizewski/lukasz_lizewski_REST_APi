package com.crud.smog.air.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AirStationIndex {
    private Long id;
    private String indexLevelName;
}
