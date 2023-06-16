package com.example.mas_skydive.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserAddress {

    String street;

    String houseNumber;

    String flatNumber;

    String city;

    String postalCode;

    String country;

}
