package com.example.mas_skydive.repository;

import com.example.mas_skydive.model.ParachuteSystem;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface ParachuteSystemRepository extends JpaRepository <ParachuteSystem, Long> {
}