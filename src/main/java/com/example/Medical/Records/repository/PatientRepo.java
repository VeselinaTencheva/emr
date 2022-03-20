package com.example.Medical.Records.repository;

import com.example.Medical.Records.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
}
