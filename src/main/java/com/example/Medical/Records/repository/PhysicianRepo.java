package com.example.Medical.Records.repository;

import com.example.Medical.Records.entity.Physician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhysicianRepo extends JpaRepository<Physician, Long> {

    List<Physician> findAllByFirstName(String name);
//    List<Doctor> findAllBySpecialization(Specialization specialization);
}
