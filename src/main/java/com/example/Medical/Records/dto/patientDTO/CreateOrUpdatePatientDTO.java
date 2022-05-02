package com.example.Medical.Records.dto.patientDTO;

import com.example.Medical.Records.models.validation.ValidConfirmPassword;
import com.example.Medical.Records.models.validation.ValidPassword;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateOrUpdatePatientDTO {

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

    private String username;

    @NotBlank(message = "National ID is mandatory")
    @Digits(integer = 10, fraction = 0, message = "National ID has to be exact 10 digits")
    private String nationalID;

    private boolean healthInsurance = false;

    private boolean hasExtraHealthInsurance = false;

    private double extraHealthInsuranceAmount = 0;

    private String extraHealthInsurancePolicy = "";

//    public void setUsername(String username) {
//        this.username = getEmail();
//    }
}
