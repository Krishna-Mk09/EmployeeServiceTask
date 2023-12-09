package com.solix.com.EmployeeServiceTask.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String role;
    private double salary;

}
