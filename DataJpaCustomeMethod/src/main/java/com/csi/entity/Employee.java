package com.csi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private long empId;
    private String empName;
    private String empAddress;
    private double empSalary;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDOB;
    private String empContact;
    private String empEmailId;
    private String empPassword;
}
