package com.solix.com.EmployeeServiceTask.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
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
