package com.example.Medical.Records.service;

import com.example.Medical.Records.entity.Role;

import java.util.List;
import java.util.UUID;

public interface RoleService {

    Role create(Role role);

    Role update(Long id,Role role);

    void delete(Role role);

    Role findById(Long id);

    List<Role> findAll();

    Role findByAuthority(String authority);

}
