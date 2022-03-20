package com.example.Medical.Records.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "privilege")
public class Privilege extends BaseEntity{

    @Column
    private String name;

    @ManyToMany(mappedBy = "privileges", fetch = FetchType.EAGER)
    private Set<Role> roles;
}
