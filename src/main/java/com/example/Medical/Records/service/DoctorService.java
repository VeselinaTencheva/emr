package com.example.Medical.Records.service;

import com.example.Medical.Records.dto.doctorDTO.CreateOrUpdateDoctorDTO;
import com.example.Medical.Records.dto.doctorDTO.DoctorDTO;
import com.example.Medical.Records.entity.Doctor;
import com.example.Medical.Records.entity.Specialization;

import javax.validation.Valid;
import java.util.List;

public interface DoctorService {

    List<DoctorDTO> findAll();

//    List<DoctorDTO> findAllByName(String name);

//    List<DoctorDTO> findAllBySpecialization(Specialization specialization);

    DoctorDTO findById(Long id);

    Doctor create(@Valid CreateOrUpdateDoctorDTO createOrUpdateDoctorDTO);

    Doctor update(Long id, CreateOrUpdateDoctorDTO createOrUpdateDoctorDTO);

    void delete(Long id);
}
