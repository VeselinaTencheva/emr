package com.example.Medical.Records.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "diagnosis", cascade = CascadeType.ALL)
    @JsonIgnoreProperties
    private List<Visitation> visitations;

}
