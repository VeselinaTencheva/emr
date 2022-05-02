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
@Entity
@Table(name = "physician")
public class Physician extends User{

    @Column(name = "unique_physician_identification_number")
    private String uniquePhysicianIdentificationNumber;

    @Column(name = "position")
    private String position;

//    @ManyToOne
//    private Department department;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Department> departments;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Patient> patients;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Appointment> appointments;

}