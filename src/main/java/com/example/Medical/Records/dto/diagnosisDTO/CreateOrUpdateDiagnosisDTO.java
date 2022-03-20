package com.example.Medical.Records.dto.diagnosisDTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CreateOrUpdateDiagnosisDTO {

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 45, message="Min 2, Max 45")
    private String name;

    private String description;
}
