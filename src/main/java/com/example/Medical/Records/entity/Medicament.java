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
public class Medicament extends BaseEntity{

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="warnings")
    private String warnings;

    @ManyToMany(mappedBy = "medicaments", fetch = FetchType.EAGER)
    private Set<Treatment> treatments;


}
