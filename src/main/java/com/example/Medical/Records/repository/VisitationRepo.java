package com.example.Medical.Records.repository;

import com.example.Medical.Records.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitationRepo extends JpaRepository<Appointment, Long> {
}
