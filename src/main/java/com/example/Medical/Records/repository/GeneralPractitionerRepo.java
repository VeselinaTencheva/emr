package com.example.Medical.Records.repository;

import com.example.Medical.Records.entity.GeneralPractitioner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneralPractitionerRepo extends JpaRepository<GeneralPractitioner, Long> {

    List<GeneralPractitioner> findAllByFirstName(String name);
    List<GeneralPractitioner> findAllByLastName(String name);

}
