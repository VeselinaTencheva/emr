package com.example.Medical.Records.service.implementations;

import com.example.Medical.Records.dto.visitationDTO.CreateOrUpdateVisitationDTO;
import com.example.Medical.Records.dto.visitationDTO.VisitationDTO;
import com.example.Medical.Records.entity.Visitation;
import com.example.Medical.Records.repository.VisitationRepo;
import com.example.Medical.Records.service.VisitationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VisitationServiceImpl implements VisitationService {

    private final VisitationRepo visitationRepo;
    private final ModelMapper modelMapper;

    private VisitationDTO convertToVisitationDTO(Visitation visitation) {
        return modelMapper.map(visitation, VisitationDTO.class);
    }

    @Override
    public List<VisitationDTO> findAll() {
        return this.visitationRepo.findAll().stream()
                .map(this::convertToVisitationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VisitationDTO findById(Long id) {
        return this.modelMapper.map(visitationRepo
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid medical examination Id: " + id)),
                VisitationDTO.class);
    }

    @Override
    public Visitation create(CreateOrUpdateVisitationDTO createOrUpdateVisitationDTO) {
        return this.visitationRepo.saveAndFlush(modelMapper.map(createOrUpdateVisitationDTO,Visitation.class));
    }

    @Override
    public Visitation update(Long id, CreateOrUpdateVisitationDTO createOrUpdateVisitationDTO) {
        Visitation visitation = modelMapper.map(createOrUpdateVisitationDTO,Visitation.class);
        visitation.setId(id);
        return this.visitationRepo.save(visitation);
    }

    @Override
    public void delete(Long id) {
        this.visitationRepo.deleteById(id);
    }
}
