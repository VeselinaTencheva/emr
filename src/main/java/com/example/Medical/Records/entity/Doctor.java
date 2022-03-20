package com.example.Medical.Records.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DiscriminatorFormula;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
//@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="doctor_type",discriminatorType=DiscriminatorType.STRING)
//@DiscriminatorFormula("case when specialisation is not null then MedicalSpecialist else GeneralPractitioner end")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Doctor extends User{

//    Inheritance Single Table does not work because on this way we would create two rows for the same doctor if he is both gp and specialist but his upin
//    would be the same, which is impossible due to impossibility of using the same upin twice

//    MappedSuperClass does not work because then we can use doctor in visitation class

//    TODO check if it is possible to register specialist and gp with the same upin
    @Column(name = "upin", nullable = false, unique = true)
    private String upin;

    @Column(name = "working_hours")
    private String workingHours;

    @Column(name = "work_place", nullable = false)
    private String workPlace;

    @Column(name = "work_with_health_fund")
    private boolean workWithHealthFund ;

    @Column(name = "price_per_visitation")
    private double pricePerVisitation;

//    @OneToMany(fetch = FetchType.EAGER)
//    private Set<Patient> patients;

}