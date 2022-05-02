package com.example.Medical.Records.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="medicament")
public class Medication extends BaseEntity{

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="brand")
    private String brand;

    @ManyToMany(mappedBy = "medications", fetch = FetchType.EAGER)
    private Set<Prescription> prescriptions;


}
