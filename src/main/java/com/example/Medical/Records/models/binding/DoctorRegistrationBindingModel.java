package com.example.Medical.Records.models.binding;

import com.example.Medical.Records.models.validation.ValidConfirmPassword;
import com.example.Medical.Records.models.validation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorRegistrationBindingModel {

    @NotBlank
    @Length(max = 5, min = 5, message = " - Error: UPIN length must be exact 5 numbers!")
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

//    @NotBlank(message = "Price is mandatory")
//    @Max(value = 2000, message = "Max 2000")
//    @Min(value = 0, message = "Min 0")
//    private double pricePerVisitation;

//    @NotBlank
//    private boolean workWithHealthFund;

//    @NotBlank
//    private String workingHours;

    @NotBlank
    private String workPlace;

}
