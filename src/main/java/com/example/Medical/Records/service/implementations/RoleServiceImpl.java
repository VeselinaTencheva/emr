package com.example.Medical.Records.service.implementations;

import com.example.Medical.Records.entity.Role;
import com.example.Medical.Records.repository.RoleRepo;
import com.example.Medical.Records.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepository;

    @Override
    public Role create(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public Role update(Long id, Role role) {
        Role newRole = role;
        newRole.setId(id);
        return this.roleRepository.saveAndFlush(newRole);
    }

    @Override
    public void delete(Role role) {
        this.roleRepository.delete(role);
    }

    @Override
    public Role findById(Long id) {
        return this.roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Role not found"));
    }

    @Override
    public Role findByAuthority(String authority) {
        return roleRepository.findByAuthority(authority);
//                .map(this::convertToSchoolDTO)
//                .collect(Collectors.toList());
    }

    @Override
    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }
}
