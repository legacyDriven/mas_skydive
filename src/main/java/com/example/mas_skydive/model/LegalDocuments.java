package com.example.mas_skydive.model;

import lombok.Data;

import java.io.File;
import java.util.Date;

@Data
public class LegalDocuments {

    private Date insuranceValidUntil;

    private Date kwtValidUntil;

    private File licenceScan;


}
