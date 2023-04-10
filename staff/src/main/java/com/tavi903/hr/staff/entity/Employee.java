package com.tavi903.hr.staff.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEES")
public class Employee extends AbstractEntity {
    private String firstName;
    private String lastName;
}