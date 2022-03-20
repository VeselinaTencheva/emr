package com.example.Medical.Records.service;

import com.example.Medical.Records.dto.patientDTO.CreateOrUpdatePatientDTO;
import com.example.Medical.Records.dto.patientDTO.PatientDTO;
import com.example.Medical.Records.entity.Patient;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.UUID;

public interface PatientService {

    List<PatientDTO> findAll();

    PatientDTO findById(Long id);

    Patient create(@Valid CreateOrUpdatePatientDTO createOrUpdatePatientDTO);

    Patient update(Long id, CreateOrUpdatePatientDTO createOrUpdatePatientDTO);

    void delete(Long id);
}
