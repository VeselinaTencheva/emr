package com.example.Medical.Records.dto.sickLeaveDTO;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

public class CreateOrUpdateSickLeaveDTO {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message="The date has to be Future or Present!")
    private Date sickLeaveStartDate;

    @Max(value = 2000, message = "Max 2000")
    @Min(value = 0, message = "Min 0")
    private int sickLeaveDuration;

}
