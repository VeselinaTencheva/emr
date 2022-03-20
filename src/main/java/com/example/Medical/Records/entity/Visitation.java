package com.example.Medical.Records.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "visitation")
public class Visitation extends BaseEntity{

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    @Column(name = "treatments")
    private String treatment;

    @ManyToOne
    private SickLeave sickLeave;

    @ManyToOne
    private Diagnosis diagnosis;

    @Column(name = "date")
    private Date date;

    @Column(name = "charge", nullable = false)
    private double charge;


}
