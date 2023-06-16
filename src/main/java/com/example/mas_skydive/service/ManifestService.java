package com.example.mas_skydive.service;

import com.example.mas_skydive.model.User;
import com.example.mas_skydive.repository.SkydiveLogResository;
import com.example.mas_skydive.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ManifestService {

    private static final List<User> loadOrganizingCache = new ArrayList<>();

    private static final List<User> uncommittedLoads = new LinkedList<>();


    private final UserRepository userRepository;

    private final SkydiveLogResository skydiveLogResository;

    public void addSkydiverToLoadOrganizing(Long id) {
        if(verifySkydiverIsEligibleToJump(id).isEmpty()) {
            throw new RuntimeException("Skydiver is not eligible to jump");
        }
        loadOrganizingCache.add(userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found")));
    }

    public List<String> verifySkydiverIsEligibleToJump(Long id) {
        List<String> errors = new LinkedList<>();
        if(!validateLegalDocuments(id)) {
            return List.of("Legal documents are not valid");
        } else if (isSuspended(id)) {
            return List.of("User is suspended");
        } else if (!validateParachuteSystem(id).isEmpty()) {
            return validateParachuteSystem(id);
        } else {
            return List.of();
        }

    }

    private List<String> validateParachuteSystem(Long id) {
    return null;
    }

    private boolean validateLegalDocuments(Long id) {
    return false;
    }



    private boolean isSuspended(Long id) {
    return false;
    }
}