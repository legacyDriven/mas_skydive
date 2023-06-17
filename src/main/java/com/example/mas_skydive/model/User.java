package com.example.mas_skydive.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Boolean isTandemPassenger;

    @NotNull
    String firstName;

    @NotNull
    String lastName;

    @Email
    String email;

    String password;
    @Past
    LocalDate birthDate;

    String phoneNumber;

    String citizenship;

    @ElementCollection
    List<UserAddress> address;

    @Embedded
    ContactPerson contactPerson;

    @Positive
    @Min(value = 35, message = "Minimalna waga to 35 kg")
    Integer weightInKgs;

    String PESEL;

    @OneToOne
    @JoinColumn(name = "dz_roleholder_id", referencedColumnName = "id")
    DzRoleHolder role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<SkydiveLog> jumplogs;


}
