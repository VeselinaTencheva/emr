package com.example.Medical.Records.dto.patientDTO;

import com.example.Medical.Records.entity.Physician;
import lombok.Data;

@Data
public class PatientDTO
{
    private String nationalID;

    private boolean healthInsurance;

    private boolean hasExtraHealthInsurance;

    private double extraHealthInsuranceAmount;

    private String extraHealthInsurancePolicy;

    private Physician physician;
}
