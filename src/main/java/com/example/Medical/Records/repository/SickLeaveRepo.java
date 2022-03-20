package com.example.Medical.Records.repository;

import com.example.Medical.Records.entity.SickLeave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SickLeaveRepo extends JpaRepository<SickLeave, Long>  {
}
