package com.example.mas_skydive.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ParachuteSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotNull
    @NotEmpty
    Integer totalJumpsAtCurrentDz;

    @NotNull
    @NotEmpty
    String mainParachute;

    @NotNull
    @NotEmpty
    String mainParachuteSerialNumber;

    @Past
    LocalDate mainCanopyDOM;

    @NotNull
    @NotEmpty
    String reserveParachute;

    @NotNull
    @NotEmpty
    String reserveParachuteSerialNumber;

    @Past
    LocalDate reserveCanopyDOM;

    @NotNull
    @NotEmpty
    String containerMakeAndModel;

    @NotNull
    @NotEmpty
    String containerSerialNumber;

    @Past
    LocalDate containerDOM;

    @NotNull
    @NotEmpty
    AadType AAD;

    @NotNull
    @NotEmpty
    String AADSerialNumber;

    @Past
    LocalDate AAD_DOM;

    LocalDate reservePackValidUntil;

    @OneToOne
    User owner;

    Boolean isAvailableForRental;
}
