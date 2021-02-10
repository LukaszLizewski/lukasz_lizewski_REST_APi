package com.crud.smog.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirStationDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("stationName")
    private String stationName;
    @JsonProperty("gegrLat")
    private double gegrLat;
    @JsonProperty("gegrLon")
    private double gegrLon;
}
