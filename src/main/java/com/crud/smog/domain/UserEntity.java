package com.crud.smog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Entity(name = "USERS")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column (name = "LAST_NAME")
    private String lastName;

    @Column (name = "ADDRESS_CITY")
    private String addressCity;

    @Column (name = "ADRRESS_STREET")
    private String addressStreet;

    @Column (name = "ADDRESS_PROVINCE")
    private String addressProvince;

    public UserEntity(Long id, String firstName, String lastName, String addressCity, String addressStreet, String addressProvince) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressCity = addressCity;
        this.addressStreet = addressStreet;
        this.addressProvince = addressProvince;
    }

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROVINCE_ID")
    private ProvinceEntity provinceEntity;
}
