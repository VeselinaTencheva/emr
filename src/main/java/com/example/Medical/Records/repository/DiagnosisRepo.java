package com.example.Medical.Records.repository;

import com.example.Medical.Records.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DiagnosisRepo extends JpaRepository<Diagnosis, Long> {
    List<Diagnosis> findAllByName(String name);
}
