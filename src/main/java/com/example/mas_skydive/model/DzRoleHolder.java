package com.example.mas_skydive.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class DzRoleHolder implements DzRole {

    @Id
    @GeneratedValue
    Long id;

    @ElementCollection
    @CollectionTable(name = "licence_table", joinColumns = @JoinColumn(name = "holder_id"))
    @Enumerated(EnumType.STRING)
    List<Licence> licences;

    @ElementCollection
    @CollectionTable(name = "rating_table", joinColumns = @JoinColumn(name = "holder_id"))
    @Enumerated(EnumType.STRING)
    List<Rating> ratings;

    @Override
    public boolean isStudent() {
        return licences.isEmpty();
    }

    @Override
    public boolean isTandemInstructor() {
        return ratings.contains(Rating.TANDEM);
    }

    @Override
    public boolean isAFFInstructor() {
        return ratings.contains(Rating.AFF);
    }

    @Override
    public boolean isPacker() {
        return ratings.contains(Rating.PACKER) || licences.contains(Licence.B);
    }

    @Override
    public boolean isInstructor() {
        return ratings.contains(Rating.INSTRUCTOR);
    }

    @Override
    public boolean isPilot() {
        return ratings.contains(Rating.PILOT);
    }

    @Override
    public boolean isCamera() {
        return licences.contains(Licence.C);
    }

    @Override
    public boolean isRigger() {
        return ratings.contains(Rating.RIGGER);
    }

    @Override
    public boolean isJumpMaster() {
        return licences.contains(Licence.C);
    }

    @Override
    public boolean isAdmin() {
        return ratings.contains(Rating.STAFF);
    }
}
