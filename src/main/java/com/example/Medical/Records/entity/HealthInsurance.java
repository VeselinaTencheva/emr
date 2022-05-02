package com.example.Medical.Records.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="health_insurance")
public class HealthInsurance extends BaseEntity{

    private double price;

    private Date paidUntilDate;

//    TODO add logic to calculate if paidUntilDate is after or equal to current date, is active must be true
    private boolean isActive;

    @OneToOne
    private Patient patient;
}
