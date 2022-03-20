package com.example.Medical.Records.service.implementations;
import com.example.Medical.Records.config.Config;
import com.example.Medical.Records.dto.doctorDTO.CreateOrUpdateDoctorDTO;
import com.example.Medical.Records.dto.doctorDTO.DoctorDTO;
import com.example.Medical.Records.entity.Doctor;
import com.example.Medical.Records.entity.Specialization;
import com.example.Medical.Records.repository.DoctorRepo;
import com.example.Medical.Records.service.DoctorService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepo doctorRepo;
    private final ModelMapper modelMapper;
    private final Config config;
//    private PasswordEncoder passwordEncoder;


    private DoctorDTO convertToDoctorDTO(Doctor doctor) {
        return modelMapper.map(doctor, DoctorDTO.class);
    }

    @Override
    public Doctor create(@Valid CreateOrUpdateDoctorDTO createOrUpdateDoctorDTO) {
        Doctor doctor = modelMapper.map(createOrUpdateDoctorDTO,Doctor.class);
        doctor.setUsername(doctor.getEmail());
        doctor.setPassword(config.passwordEncoder().encode(doctor.getPassword()));
        doctor.setEnabled(true);
        doctor.setAccountNonExpired(true);
        doctor.setAccountNonLocked(true);
        doctor.setCredentialsNonExpired(true);
        System.out.println("last step");
        return this.doctorRepo.save(doctor);
    }

    @Override
    public Doctor update(Long id, CreateOrUpdateDoctorDTO createOrUpdateDoctorDTO) {
        Doctor doctor = modelMapper.map(createOrUpdateDoctorDTO,Doctor.class);
        doctor.setId(id);
        return this.doctorRepo.save(doctor);
    }

    @Override
    public void delete(Long id) {
        this.doctorRepo.deleteById(id);
    }

    @Override
    public DoctorDTO findById(Long id) {
        return this.modelMapper.map(doctorRepo
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid doctor Id: " + id)),
                DoctorDTO.class);
    }

    @Override
    public List<DoctorDTO> findAll() {
        return this.doctorRepo.findAll().stream()
                .map(this::convertToDoctorDTO)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<DoctorDTO> findAllByName(String name) {
//        return this.doctorRepo.findAllByName(name).stream()
//                .map(this::convertToDoctorDTO)
//                .collect(Collectors.toList());
//    }

//    @Override
//    public List<DoctorDTO> findAllBySpecialization(Specialization specialization) {
//        return this.doctorRepo.findAllBySpecialization(specialization).stream()
//                .map(this::convertToDoctorDTO)
//                .collect(Collectors.toList());
//    }


}
