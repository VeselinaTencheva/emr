package com.example.Medical.Records.service.implementations;

import com.example.Medical.Records.dto.diagnosisDTO.CreateOrUpdateDiagnosisDTO;
import com.example.Medical.Records.dto.diagnosisDTO.DiagnosisDTO;
import com.example.Medical.Records.entity.Diagnosis;
import com.example.Medical.Records.repository.DiagnosisRepo;
import com.example.Medical.Records.service.DiagnosisService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DiagnosisServiceImpl implements DiagnosisService {

    private final DiagnosisRepo diagnosisRepo;

    private final ModelMapper modelMapper;

    private DiagnosisDTO convertToDiagnosisDTO(Diagnosis diagnosis) {
        return modelMapper.map(diagnosis, DiagnosisDTO.class);
    }

    @Override
    public Diagnosis create(@Valid CreateOrUpdateDiagnosisDTO createDiagnosisDTO) {
        return this.diagnosisRepo.save(modelMapper.map(createDiagnosisDTO, Diagnosis.class));
    }

    @Override
    public Diagnosis update(Long id, CreateOrUpdateDiagnosisDTO diagnosisDTO) {
        Diagnosis diagnosis = modelMapper.map(diagnosisDTO,Diagnosis.class);
        diagnosis.setId(id);
        return this.diagnosisRepo.save(diagnosis);
    }

    @Override
    public void delete(Long id) {
        this.diagnosisRepo.deleteById(id);
    }

    @Override
    public DiagnosisDTO findById(Long id) {
        return this.modelMapper.map(diagnosisRepo
                                    .findById(id)
                                    .orElseThrow(() -> new IllegalArgumentException("Invalid diagnosis Id: " + id)),
                                    DiagnosisDTO.class);
    }

    @Override
    public List<DiagnosisDTO> findAll() {
        return this.diagnosisRepo.findAll().stream()
                .map(this::convertToDiagnosisDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DiagnosisDTO> findByName(String name) {
        return this.diagnosisRepo.findAllByName(name).stream()
                .map(this::convertToDiagnosisDTO)
                .collect(Collectors.toList());
    }
}
