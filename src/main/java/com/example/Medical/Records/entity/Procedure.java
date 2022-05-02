package com.example.Medical.Records.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "physician")
public class Procedure extends BaseEntity{

//    Procedure is for example consultation

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private double cost;

    @OneToMany(mappedBy = "procedure", cascade = CascadeType.ALL)
    private Set<Appointment> appointments;
}
