package com.example.Medical.Records.dto.physicianDTO;

import com.example.Medical.Records.entity.Department;
import lombok.Data;

@Data
public class PhysicianDTO {

    private String uniquePhysicianIdentificationNumber;

    private String snn;

    private String firstName;

    private String lastName;

    private String email;

    private String position;

//    private Department department;
}