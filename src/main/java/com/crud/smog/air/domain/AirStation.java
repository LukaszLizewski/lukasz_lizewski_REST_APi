package com.crud.smog.air.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AirStation {
    private Long id;
    private String stationName;
    private double gegrLat;
    private double gegrLon;

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId().hashCode();
        result = 31 * result + getStationName().hashCode();
        temp = Double.doubleToLongBits(getGegrLat());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getGegrLon());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
