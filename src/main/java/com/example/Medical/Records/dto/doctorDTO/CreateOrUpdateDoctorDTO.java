package com.example.Medical.Records.dto.doctorDTO;

import com.example.Medical.Records.entity.Specialization;
import com.example.Medical.Records.models.validation.ValidConfirmPassword;
import com.example.Medical.Records.models.validation.ValidPassword;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class CreateOrUpdateDoctorDTO {

    @NotBlank(message = "UPIN is mandatory")
    @Length(max = 5, min = 5,message = " - Error: First  length must be between 1 or 32 characters!")
    private String upin;

    @NotBlank(message = "First name is mandatory")
    @Length(max = 32, min = 1,message = " - Error: First Name length must be between 1 or 32 characters!")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Length(max = 32, min = 1,message = " - Error: Last Name length must be between 1 or 32 characters!")
    private String lastName;

    @ValidPassword
    private String password;

    @ValidConfirmPassword(first = "password", second = "confirmPassword", message = "- Error: The password fields must match!")
    private String confirmPassword;

    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

//    @NotBlank
//    private boolean workWithHealthFund;

//    @NotBlank(message = "Price is mandatory")
//    @Max(value = 2000, message = "Max 2000")
//    @Min(value = 0, message = "Min 0")
//    private double pricePerVisitation;
//
//    @NotBlank(message = "Working Hours is mandatory")
//    private String workingHours;

    @NotBlank(message = "Work Place is mandatory")
    private String workPlace;
}
