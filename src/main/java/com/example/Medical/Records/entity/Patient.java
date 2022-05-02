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

    @Column(name = "address")
    private String address;

    @ManyToOne
    private Physician gp;

    @OneToOne
    private HealthInsurance healthInsurance;

}
