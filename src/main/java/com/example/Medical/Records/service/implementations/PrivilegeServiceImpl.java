package com.example.Medical.Records.service.implementations;

import com.example.Medical.Records.entity.Privilege;
import com.example.Medical.Records.entity.Role;
import com.example.Medical.Records.repository.PrivilegeRepo;
import com.example.Medical.Records.service.PrivilegeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PrivilegeServiceImpl implements PrivilegeService {

    private final PrivilegeRepo privilegeRepo;

    @Override
    public Privilege create(Privilege privilege) {
        return this.privilegeRepo.save(privilege);
    }

    @Override
    public Privilege update(Long id, Privilege privilege) {
        Privilege newPrivilege = privilege;
        newPrivilege.setId(id);
        return this.privilegeRepo.saveAndFlush(newPrivilege);
    }

    @Override
    public void delete(Privilege privilege) {
        this.privilegeRepo.delete(privilege);
    }

    @Override
    public Privilege findById(Long id) {
        return this.privilegeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Privilege not found"));
    }

    @Override
    public Privilege findByName(String name) {
        return this.privilegeRepo.findByName(name);
    }

    @Override
    public List<Privilege> findAll() {
        return this.privilegeRepo.findAll();
    }

}
