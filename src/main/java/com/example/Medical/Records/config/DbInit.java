package com.example.Medical.Records.config;

import com.example.Medical.Records.entity.Privilege;
import com.example.Medical.Records.entity.Role;
import com.example.Medical.Records.entity.User;
import com.example.Medical.Records.repository.PrivilegeRepo;
import com.example.Medical.Records.repository.RoleRepo;
import com.example.Medical.Records.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DbInit implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PrivilegeRepo privilegeRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {

//        if(userRepo.findAll().size() > 0){
//            this.userRepo.deleteAll();
//        }
//        if(roleRepo.findAll().size() > 0)
//            this.roleRepo.deleteAll();
//        if(privilegeRepo.findAll().size() > 0)
//            this.privilegeRepo.deleteAll();
//
//        Privilege readPatient
//                = createPrivilegeIfNotFound("READ_PATIENT");
//        Privilege readMedicalSpecialist
//                = createPrivilegeIfNotFound("READ_MEDICAL_SPECIALIST");
//        Privilege readGeneralPractitioner
//                = createPrivilegeIfNotFound("READ_GENERAL_PRACTITIONER");
//        Privilege writePatient
//                = createPrivilegeIfNotFound("WRITE_PATIENT)");
//        Privilege writeMedicalSpecialist
//                = createPrivilegeIfNotFound("WRITE_MEDICAL_SPECIALIST");
//        Privilege writeGeneralPractitioner
//                = createPrivilegeIfNotFound("WRITE_GENERAL_PRACTITIONER");
//        Privilege readDiagnosis
//                = createPrivilegeIfNotFound("READ_DIAGNOSIS");
//        Privilege writeDiagnosis
//                = createPrivilegeIfNotFound("WRITE_DIAGNOSIS");
//        Privilege readSickLeave
//                = createPrivilegeIfNotFound("READ_SICK_LEAVE");
//        Privilege writeSickLeave
//                = createPrivilegeIfNotFound("WRITE_SICK_LEAVE");
//        Privilege readVisitation
//                = createPrivilegeIfNotFound("READ_VISITATION");
//        Privilege writeVisitation
//                = createPrivilegeIfNotFound("WRITE_VISITATION");
//
//
//        Set<Privilege> adminPrivileges = Arrays.asList(
//               readPatient, readDiagnosis, readGeneralPractitioner, readMedicalSpecialist,
//                readVisitation, readSickLeave, writePatient, writeDiagnosis,
//                writeGeneralPractitioner, writeMedicalSpecialist, writeVisitation, writeSickLeave
//        ).stream().collect(Collectors.toSet());
//
//        Set<Privilege> patientPrivileges = Arrays.asList(
//                readPatient, readGeneralPractitioner, readMedicalSpecialist, writePatient,
//                readDiagnosis, readSickLeave, readVisitation
//        ).stream().collect(Collectors.toSet());
//
//        Set<Privilege> medicalSpecialistPrivileges = Arrays.asList(
//                readPatient, readDiagnosis, readGeneralPractitioner, readMedicalSpecialist,
//                readVisitation, readSickLeave, writeMedicalSpecialist,
//                writeDiagnosis, writeVisitation, writeSickLeave
//        ).stream().collect(Collectors.toSet());
//
//        Set<Privilege> generalPractitionerPrivileges = Arrays.asList(
//                readPatient, readDiagnosis, readGeneralPractitioner, readMedicalSpecialist,
//                readVisitation, readSickLeave, writeGeneralPractitioner,
//                writeDiagnosis, writeVisitation, writeSickLeave
//        ).stream().collect(Collectors.toSet());
//
////       TODO create GP role and privileges
//
//        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
//        createRoleIfNotFound("ROLE_PATIENT", patientPrivileges);
//        createRoleIfNotFound("ROLE_MEDICAL_SPECIALIST", medicalSpecialistPrivileges);
//        createRoleIfNotFound("ROLE_GENERAL_PRACTITIONER", generalPractitionerPrivileges);
//
//        Role adminRole = roleRepo.findByAuthority("ROLE_ADMIN");
//        User user = new User();
//
////        user.setId(UUID.randomUUID());
//        user.setFirstName("Veselina");
//        user.setLastName("Tencheva");
//        user.setPassword(encoder.encode("vesi"));
//        user.setEmail("vesi");
//        user.setUsername("vesi");
//        user.setAuthorities(Arrays.asList(adminRole).stream().collect(Collectors.toSet()));
//        user.setEnabled(true);
//        user.setAccountNonExpired(true);
//        user.setAccountNonLocked(true);
//        user.setCredentialsNonExpired(true);
//        userRepo.save(user);

    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {
//        Privilege privilege = privilegeRepo.findByName(name);
//        if (privilege == null) {
        Privilege privilege = new Privilege();
//            privilege.setId(UUID.randomUUID());
            privilege.setName(name);
            privilegeRepo.save(privilege);
//        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(
            String name, Set<Privilege> privileges) {
//        Role role = roleRepo.findByAuthority(name);
//        if (role == null) {
            Role role = new Role();
//            role.setId(UUID.randomUUID());
            role.setAuthority(name);
            role.setPrivileges(privileges);
            roleRepo.save(role);
//        }
        return role;
    }
}
