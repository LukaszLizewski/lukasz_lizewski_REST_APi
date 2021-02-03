package com.crud.smog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter

@NoArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String addressCity;
    private String addressStreet;
    private String addressProvince;

    public UserDto(Long id, String firstName, String lastName, String addressCity, String addressStreet, String addressProvince) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressCity = addressCity;
        this.addressStreet = addressStreet;
        this.addressProvince = addressProvince;
    }
}
