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

    @Column(name = "PROVINCE_NAME")
    private String provinceName;

    @Column(name = "PROVINCE_LONGITUDE")
    private double centralLongitude;

    @Column(name = "PROVINCE_LATITUDE")
    private double centralLatitude;
}
