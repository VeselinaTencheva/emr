package com.example.Medical.Records.repository;


import com.example.Medical.Records.entity.Doctor;
import com.example.Medical.Records.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

    List<Doctor> findAllByFirstName(String name);
//    List<Doctor> findAllBySpecialization(Specialization specialization);
}
