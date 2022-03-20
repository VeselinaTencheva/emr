package com.example.Medical.Records.repository;

import com.example.Medical.Records.entity.Privilege;
import com.example.Medical.Records.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PrivilegeRepo extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);

    Optional<Privilege> findById(Long id);
}
