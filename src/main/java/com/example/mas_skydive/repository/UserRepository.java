package com.example.mas_skydive.repository;

import com.example.mas_skydive.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
