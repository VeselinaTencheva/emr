package com.example.Medical.Records.dto.physicianDTO;

import com.example.Medical.Records.entity.Department;
import com.example.Medical.Records.models.validation.ValidConfirmPassword;
import com.example.Medical.Records.models.validation.ValidPassword;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class CreateOrUpdatePhysicianDTO {

    @NotBlank
    @Length(max = 6, min = 6, message = " - Error: Unique Physician Identification Number length must be exact 6 numbers!")
    private String uniquePhysicianIdentificationNumber;

    @NotBlank(message = "SSN is mandatory")
    @Length(max = 9, min = 9,message = " - Error: length must be exact 9!")
    @NumberFormat
    private String snn;

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

    @NotBlank
    private String position;

//    @NotBlank
//    private Department department;
}
