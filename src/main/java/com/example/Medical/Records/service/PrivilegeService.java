package com.example.Medical.Records.service;

import com.example.Medical.Records.entity.Privilege;
import com.example.Medical.Records.entity.Role;

import java.util.List;
import java.util.UUID;

public interface PrivilegeService {

    Privilege create(Privilege privilege);

    Privilege update(Long id, Privilege privilege);

    void delete(Privilege privilege);

    Privilege findById(Long id);

    Privilege findByName(String name);

    List<Privilege> findAll();
}
