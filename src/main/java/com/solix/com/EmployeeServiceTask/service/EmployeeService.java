package com.solix.com.EmployeeServiceTask.service;

import com.solix.com.EmployeeServiceTask.domain.Employee;
import com.solix.com.EmployeeServiceTask.exception.EmployeeAlreadyExists;
import com.solix.com.EmployeeServiceTask.exception.EmployeeNotFound;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeService {

    Employee saveUser(Employee employee) throws EmployeeAlreadyExists;

    void deleteEmployeeByEmail(String email) throws EmployeeNotFound;

    Employee updateEmployeeByEmail(Employee employee, String email);

    Employee getEmployeeByEmail(String email) throws EmployeeNotFound;

    List<String> getAllEmails();

    List<Employee> getAllEmployees();

    Employee incrementSalary(String email, int increment) throws EmployeeNotFound;

}
