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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirStation)) return false;

        AirStation that = (AirStation) o;

        if (Double.compare(that.getGegrLat(), getGegrLat()) != 0) return false;
        if (Double.compare(that.getGegrLon(), getGegrLon()) != 0) return false;
        if (!getId().equals(that.getId())) return false;
        return getStationName().equals(that.getStationName());
    }

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
