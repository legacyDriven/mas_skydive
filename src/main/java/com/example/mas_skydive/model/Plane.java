package com.example.mas_skydive.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Plane {

    private String manufacturer;

    private String model;

    private String registration;

    private String capacity;

    private String engine;

    private String maxLoadInKgs;

}
