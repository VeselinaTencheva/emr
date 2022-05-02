package com.example.Medical.Records.service.implementations;
import com.example.Medical.Records.config.Config;
import com.example.Medical.Records.dto.physicianDTO.CreateOrUpdatePhysicianDTO;
import com.example.Medical.Records.dto.physicianDTO.PhysicianDTO;
import com.example.Medical.Records.entity.Physician;
import com.example.Medical.Records.repository.PhysicianRepo;
import com.example.Medical.Records.service.PhysicianService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PhysicianServiceImpl implements PhysicianService {

    private final PhysicianRepo physicianRepo;
    private final ModelMapper modelMapper;
    private final Config config;
//    private PasswordEncoder passwordEncoder;


    private PhysicianDTO convertToPhysicianDTO(Physician physician) {
        return modelMapper.map(physician, PhysicianDTO.class);
    }

    @Override
    public Physician create(@Valid CreateOrUpdatePhysicianDTO createOrUpdatePhysicianDTO) {
        Physician physician = modelMapper.map(createOrUpdatePhysicianDTO,Physician.class);
        physician.setUsername(physician.getEmail());
        physician.setPassword(config.passwordEncoder().encode(physician.getPassword()));
        physician.setEnabled(true);
        physician.setAccountNonExpired(true);
        physician.setAccountNonLocked(true);
        physician.setCredentialsNonExpired(true);
        System.out.println("last step");
        return this.physicianRepo.save(physician);
    }

    @Override
    public Physician update(Long id, CreateOrUpdatePhysicianDTO createOrUpdatePhysicianDTO) {
        Physician physician = modelMapper.map(createOrUpdatePhysicianDTO,Physician.class);
        physician.setId(id);
        return this.physicianRepo.save(physician);
    }

    @Override
    public void delete(Long id) {
        this.physicianRepo.deleteById(id);
    }

    @Override
    public PhysicianDTO findById(Long id) {
        return this.modelMapper.map(physicianRepo
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid doctor Id: " + id)),
                PhysicianDTO.class);
    }

    @Override
    public List<PhysicianDTO> findAll() {
        return this.physicianRepo.findAll().stream()
                .map(this::convertToPhysicianDTO)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<DoctorDTO> findAllByName(String name) {
//        return this.doctorRepo.findAllByName(name).stream()
//                .map(this::convertToPhysicianDTO)
//                .collect(Collectors.toList());
//    }

//    @Override
//    public List<DoctorDTO> findAllBySpecialization(Specialization specialization) {
//        return this.doctorRepo.findAllBySpecialization(specialization).stream()
//                .map(this::convertToPhysicianDTO)
//                .collect(Collectors.toList());
//    }


}
