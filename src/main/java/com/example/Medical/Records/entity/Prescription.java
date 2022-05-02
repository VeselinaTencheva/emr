package com.example.Medical.Records.entity;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@NoArgsConstructor
@Entity
@Table(name = "treatment")
public class Prescription extends BaseEntity{

    @ManyToOne
    private Appointment appointment;

    private String dose;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Medication> medications;
}
