package com.example.mas_skydive.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class SkydiveLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    String jumpDate;

    String loadNumber;

    String mainCanopyModelAndSizeInFeet;

    String exitAltitudeInMeters;

    String deploymentAltitudeInMeters;

    String freefallTime;

    @Embedded
    Plane plane;

    String dropZoneICAO;

    String description;

}
