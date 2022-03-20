package com.example.Medical.Records.service.implementations;
import com.example.Medical.Records.dto.patientDTO.CreateOrUpdatePatientDTO;
import com.example.Medical.Records.dto.patientDTO.PatientDTO;
import com.example.Medical.Records.entity.Patient;
import com.example.Medical.Records.entity.Role;
import com.example.Medical.Records.repository.PatientRepo;
import com.example.Medical.Records.service.PatientService;
import com.example.Medical.Records.service.RoleService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepo patientRepo;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;

    private PatientDTO convertToPatientDTO(Patient patient) {
        return modelMapper.map(patient, PatientDTO.class);
    }

    @Override
    public List<PatientDTO> findAll() {
        return this.patientRepo.findAll().stream()
                .map(this::convertToPatientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDTO findById(Long id) {
        return this.modelMapper.map(patientRepo
                                    .findById(id)
                                    .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id: " + id)),
                                    PatientDTO.class);
    }

    @Override
    public Patient create(CreateOrUpdatePatientDTO createOrUpdatePatientDTO) {
        createOrUpdatePatientDTO.setPassword(this.bCryptPasswordEncoder.encode(createOrUpdatePatientDTO.getPassword()));

        Patient patient = modelMapper.map(createOrUpdatePatientDTO,Patient.class);
        patient.setUsername(patient.getEmail());
        patient.setEnabled(true);
        patient.setAccountNonExpired(true);
        patient.setAccountNonLocked(true);
        patient.setCredentialsNonExpired(true);
        patient.setAuthorities(new HashSet<>());
        patient.getAuthorities().add(this.roleService.findByAuthority("ROLE_PATIENT"));
        return this.patientRepo.saveAndFlush(patient);
    }

    @Override
    public Patient update(Long id, CreateOrUpdatePatientDTO createOrUpdatePatientDTO) {
        Patient patient = modelMapper.map(createOrUpdatePatientDTO,Patient.class);
        patient.setId(id);
        return this.patientRepo.save(patient);
    }

    @Override
    public void delete(Long id) {
        this.patientRepo.deleteById(id);
    }
}
