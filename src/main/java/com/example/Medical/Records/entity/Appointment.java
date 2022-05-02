package com.example.Medical.Records.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment extends BaseEntity{

    @Column(name = "date")
    private Date date;

    @OneToOne
    private SickLeave sickLeave;

    // TODO Can we have more than one diagnosis for one appointment? If not then the relationship must be one to one
    @ManyToOne
    private Diagnosis diagnosis;

    @ManyToOne
    private Procedure procedure;

    @ManyToOne
    private Prescription prescription;

    @ManyToOne
    private Patient patient;

    @ManyToMany(mappedBy = "appointments", fetch = FetchType.EAGER)
    private Set<Physician> physicians;

}
