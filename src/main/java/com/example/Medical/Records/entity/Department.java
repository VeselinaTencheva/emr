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
@Table(name = "department")
public class Department extends BaseEntity{

//    TODO add head department eventually

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "department_type", nullable = false)
    private DepartmentType departmentType;

//    @OneToMany(fetch = FetchType.EAGER)
//    private Set<Physician> physicians;

    @ManyToMany(mappedBy = "departments", fetch = FetchType.EAGER)
    private Set<Physician> physicians;
}
