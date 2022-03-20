package com.example.Medical.Records.entity;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@NoArgsConstructor
@Entity
@Table(name = "treatment")
public class Treatment extends BaseEntity{

    @Column(name="type")
    private TreatmentType type;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Medicament> medicaments;
}
