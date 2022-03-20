package com.example.Medical.Records.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
//@DiscriminatorValue("MedicalSpecialist")
public class MedicalSpecialist extends Doctor{

//    TODO add more columns
    @Column(name = "specialization", nullable = false)
    private Specialization specialization;
}
