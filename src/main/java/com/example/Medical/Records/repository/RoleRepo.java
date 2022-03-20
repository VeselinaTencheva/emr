package com.example.Medical.Records.repository;

import com.example.Medical.Records.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByAuthority(String authority);

    Optional<Role> findById(Long id);

}
