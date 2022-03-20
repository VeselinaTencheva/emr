package com.example.Medical.Records.repository;

import com.example.Medical.Records.entity.Visitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VisitationRepo extends JpaRepository<Visitation, Long> {
}
