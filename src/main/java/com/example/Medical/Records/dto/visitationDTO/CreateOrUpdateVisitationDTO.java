package com.example.Medical.Records.dto.visitationDTO;

import com.example.Medical.Records.entity.Diagnosis;
import com.example.Medical.Records.entity.Patient;
import com.example.Medical.Records.entity.Physician;
import com.example.Medical.Records.entity.SickLeave;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Data
public class CreateOrUpdateVisitationDTO {

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message="The date has to be in the present!")
    private Date date;


    private SickLeave sickLeave;

    @NotBlank(message = "Physician is mandatory")
    private Physician physician;

    @NotBlank(message = "Patient is mandatory")
    private Patient patient;

    private Diagnosis diagnosis;

    private String treatment;
}
