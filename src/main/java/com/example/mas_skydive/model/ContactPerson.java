package com.example.mas_skydive.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Embeddable
public class ContactPerson {

        String contactName;

        String contactLastName;

        String contactPhoneNumber;

        String contactPersonemail;
}
