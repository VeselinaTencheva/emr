package com.example.Medical.Records.models.binding;

import com.example.Medical.Records.entity.Department;
import com.example.Medical.Records.entity.DepartmentType;
import com.example.Medical.Records.models.validation.ValidConfirmPassword;
import com.example.Medical.Records.models.validation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhysicianRegistrationBindingModel {

    @NotBlank
    @Length(max = 6, min = 6, message = " - Error: Unique Physician Identification Number length must be exact 6 numbers!")
    private String uniquePhysicianIdentificationNumber;

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

    @NotBlank(message = "SSN is mandatory")
    @Digits(integer = 9, fraction = 0, message = "SSN has to be exact 9 digits")
    private String ssn;

    @NotBlank
    private String position;

//    private DepartmentType department;


}