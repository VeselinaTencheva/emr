package com.example.Medical.Records.service;

import com.example.Medical.Records.dto.visitationDTO.CreateOrUpdateVisitationDTO;
import com.example.Medical.Records.dto.visitationDTO.VisitationDTO;
import com.example.Medical.Records.entity.Visitation;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.UUID;

public interface VisitationService {

    List<VisitationDTO> findAll();

    VisitationDTO findById(Long id);

    Visitation create(@Valid CreateOrUpdateVisitationDTO createOrUpdateMedicalExaminationDTO);

    Visitation update(Long id, CreateOrUpdateVisitationDTO createOrUpdateMedicalExaminationDTO);

    void delete(Long id);
}
