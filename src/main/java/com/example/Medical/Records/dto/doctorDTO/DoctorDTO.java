package com.example.Medical.Records.dto.doctorDTO;

import com.example.Medical.Records.entity.Specialization;
import lombok.Data;

@Data
public class DoctorDTO {

    private String upin;

    private Specialization specialization;

    private boolean workWithHealthFund = false;

    private boolean workingWithExtraHealthInsurance = false;

    private double pricePerExamination;

    private String workingHours;

    private String workPlace;
}
