package com.example.mas_skydive.model;

import lombok.Data;

import java.io.File;
import java.time.LocalDate;

@Data
public class LegalDocuments {

    private LocalDate insuranceValidUntil;

    private String policyNumber;

    private String insuranceCompany;

    private LocalDate kwtValidUntil;

    private File licenceScan;

}
