package com.example.mas_skydive.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Date;

public class ParachuteSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String mainParachute;

    String reserveParachute;

    String containerMakeAndModel;

    String AAD;

    Date reservePackValidUntil;

    @OneToOne
    User owner;

    Boolean isAvailableForRental;
}
