package com.crud.smog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
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
}
