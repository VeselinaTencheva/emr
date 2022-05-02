package com.example.Medical.Records.service;

import com.example.Medical.Records.dto.visitationDTO.CreateOrUpdateVisitationDTO;
import com.example.Medical.Records.dto.visitationDTO.VisitationDTO;
import com.example.Medical.Records.entity.Appointment;

import javax.validation.Valid;
import java.util.List;

public interface VisitationService {

    List<VisitationDTO> findAll();

    VisitationDTO findById(Long id);

    Appointment create(@Valid CreateOrUpdateVisitationDTO createOrUpdateMedicalExaminationDTO);

    Appointment update(Long id, CreateOrUpdateVisitationDTO createOrUpdateMedicalExaminationDTO);

    void delete(Long id);
}
