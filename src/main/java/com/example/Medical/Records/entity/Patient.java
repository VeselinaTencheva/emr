package com.example.Medical.Records.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient extends User{

    @Column(name = "national_id", nullable = false, unique = true)
    private String nationalID;

    @Column(name = "has_health_insurance", nullable = false)
    private boolean hasHealthInsurance;

    @Column(name = "has_extra_health_insurance", nullable = false)
    private boolean hasExtraHealthInsurance;

    @Column(name = "extra_health_insurance_amount")
    private double extraHealthInsuranceAmount;

    @Column(name = "extra_health_insurance_policyID")
    private String extraHealthInsurancePolicyID;

    @ManyToOne
    private Doctor gp;
//    private GP gp;

}
