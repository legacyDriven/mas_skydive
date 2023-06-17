package com.example.mas_skydive.service;

import com.example.mas_skydive.model.ParachuteSystem;
import com.example.mas_skydive.repository.ParachuteSystemRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class GearRentalService {

    ParachuteSystemRepository parachuteSystemRepository;

}
