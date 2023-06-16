package com.example.mas_skydive.service;

import com.example.mas_skydive.model.User;
import com.example.mas_skydive.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
    }

    public void deleteUser(User selectedUser) {
    }
}
