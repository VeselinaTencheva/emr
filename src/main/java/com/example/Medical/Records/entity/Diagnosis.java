package com.example.Medical.Records.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "diagnosis")
public class Diagnosis extends BaseEntity {

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="description",nullable = false)
    private String description;

    // TODO Can we have more than one diagnosis for one appointment? If not then the relationship must be one to one
    @OneToMany(mappedBy = "diagnosis", cascade = CascadeType.ALL)
    @JsonIgnoreProperties
    private Set<Appointment> appointments;

}
