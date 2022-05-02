package com.example.Medical.Records.service;

import com.example.Medical.Records.dto.physicianDTO.CreateOrUpdatePhysicianDTO;
import com.example.Medical.Records.dto.physicianDTO.PhysicianDTO;
import com.example.Medical.Records.entity.Physician;

import javax.validation.Valid;
import java.util.List;

public interface PhysicianService {

    List<PhysicianDTO> findAll();

//    List<DoctorDTO> findAllByName(String name);

//    List<DoctorDTO> findAllBySpecialization(Specialization specialization);

    PhysicianDTO findById(Long id);

    Physician create(@Valid CreateOrUpdatePhysicianDTO createOrUpdatePhysicianDTO);

    Physician update(Long id, CreateOrUpdatePhysicianDTO createOrUpdatePhysicianDTO);

    void delete(Long id);
}
