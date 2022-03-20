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
//@DiscriminatorValue("GeneralPractitioner")
public class GeneralPractitioner extends Doctor {

//    TODO add more columns

    @Column(name = "identifier_code", nullable = false, unique = true)
    private Long identifier_code;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Patient> patients;

}
