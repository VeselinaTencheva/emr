package com.example.Medical.Records.dto.visitationDTO;

import com.example.Medical.Records.entity.Diagnosis;
import com.example.Medical.Records.entity.Patient;
import com.example.Medical.Records.entity.Physician;
import com.example.Medical.Records.entity.SickLeave;
import lombok.Data;

import java.util.Date;

@Data
public class VisitationDTO {

    private Date date;

    private SickLeave sickLeave;

    private Physician physician;

    private Patient patient;

    private Diagnosis diagnosis;

    private String treatment;


}
