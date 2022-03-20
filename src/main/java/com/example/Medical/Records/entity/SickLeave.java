package com.example.Medical.Records.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sick_leave")
public class SickLeave extends BaseEntity{

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "duration", nullable = false)
    private Integer duration;

}
