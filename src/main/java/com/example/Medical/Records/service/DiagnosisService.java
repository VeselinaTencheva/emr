package com.example.Medical.Records.service;


import com.example.Medical.Records.dto.diagnosisDTO.CreateOrUpdateDiagnosisDTO;
import com.example.Medical.Records.dto.diagnosisDTO.DiagnosisDTO;
import com.example.Medical.Records.entity.Diagnosis;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.UUID;

public interface DiagnosisService  {

    List<DiagnosisDTO> findAll();

    List<DiagnosisDTO> findByName(@Min(1) String name);

    DiagnosisDTO findById(Long id);

    Diagnosis create(@Valid CreateOrUpdateDiagnosisDTO createDiagnosisDTO);

    Diagnosis update(Long id, CreateOrUpdateDiagnosisDTO updateSchoolDTO);

    void delete(Long id);
}
