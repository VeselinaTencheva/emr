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
////        TODO add read and write privileges
//
//        Privilege readPatient
//                = createPrivilegeIfNotFound("READ_PATIENT");
//        Privilege readPhysician
//                = createPrivilegeIfNotFound("READ_PHYSICIAN");
////        Privilege readGeneralPractitioner
////                = createPrivilegeIfNotFound("READ_GENERAL_PRACTITIONER");
//        Privilege writePatient
//                = createPrivilegeIfNotFound("WRITE_PATIENT)");
//        Privilege writePhysician
//                = createPrivilegeIfNotFound("WRITE_PHYSICIAN");
////        Privilege writeGeneralPractitioner
////                = createPrivilegeIfNotFound("WRITE_GENERAL_PRACTITIONER");
//        Privilege readDiagnosis
//                = createPrivilegeIfNotFound("READ_DIAGNOSIS");
//        Privilege writeDiagnosis
//                = createPrivilegeIfNotFound("WRITE_DIAGNOSIS");
//        Privilege readSickLeave
//                = createPrivilegeIfNotFound("READ_SICK_LEAVE");
//        Privilege writeSickLeave
//                = createPrivilegeIfNotFound("WRITE_SICK_LEAVE");
//        Privilege readAppointment
//                = createPrivilegeIfNotFound("READ_APPOINTMENT");
//        Privilege writeAppointment
//                = createPrivilegeIfNotFound("WRITE_APPOINTMENT");
//        Privilege readDepartment
//                = createPrivilegeIfNotFound("READ_DEPARTMENT");
//        Privilege writeDepartment
//                = createPrivilegeIfNotFound("WRITE_DEPARTMENT");
//        Privilege readMedication
//                = createPrivilegeIfNotFound("READ_MEDICATION");
//        Privilege writeMedication
//                = createPrivilegeIfNotFound("WRITE_MEDICATION");
//        Privilege readPrescribe
//                = createPrivilegeIfNotFound("READ_PRESCRIBE");
//        Privilege writePrescribe
//                = createPrivilegeIfNotFound("WRITE_PRESCRIBE");
//        Privilege readProcedure
//                = createPrivilegeIfNotFound("READ_PROCEDURE");
//        Privilege writeProcedure
//                = createPrivilegeIfNotFound("WRITE_PROCEDURE");
//
//
//        Set<Privilege> adminPrivileges = Arrays.asList(
//                readAppointment, readDepartment, readDiagnosis, readMedication,
//                readPatient, readPhysician, readPrescribe, readProcedure,
//                readSickLeave, writeAppointment, writeDepartment, writeDiagnosis,
//                writeMedication, writePatient, writePhysician, writePrescribe,
//                writeProcedure, writeSickLeave
//        ).stream().collect(Collectors.toSet());
//
//        Set<Privilege> patientPrivileges = Arrays.asList(
//                readAppointment, readDepartment, readDiagnosis, readMedication,
//                readPatient, readPhysician, readPrescribe, readProcedure, writePatient
//        ).stream().collect(Collectors.toSet());
////
//        Set<Privilege> physicianPrivileges = Arrays.asList(
//                readAppointment, readDepartment, readDiagnosis, readMedication,
//                readPatient, readPhysician, readPrescribe, readProcedure,
//                readSickLeave, writeAppointment, writeDiagnosis, writePatient,
//                writePhysician, writePrescribe, writeProcedure, writeSickLeave
//        ).stream().collect(Collectors.toSet());
////
////        Set<Privilege> generalPractitionerPrivileges = Arrays.asList(
////                readPatient, readDiagnosis, readGeneralPractitioner, readMedicalSpecialist,
////                readVisitation, readSickLeave, writeGeneralPractitioner,
////                writeDiagnosis, writeVisitation, writeSickLeave
////        ).stream().collect(Collectors.toSet());
////
//////       TODO create GP role and privileges
////
//        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
//        createRoleIfNotFound("ROLE_PATIENT", patientPrivileges);
//        createRoleIfNotFound("ROLE_PHYSICIAN", physicianPrivileges);
////        createRoleIfNotFound("ROLE_GENERAL_PRACTITIONER", generalPractitionerPrivileges);
////
//        Role adminRole = roleRepo.findByAuthority("ROLE_ADMIN");
//        User user = new User();
////
////        user.setId(UUID.randomUUID());
//        user.setFirstName("Veselina");
//        user.setSsn("123456789");
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
