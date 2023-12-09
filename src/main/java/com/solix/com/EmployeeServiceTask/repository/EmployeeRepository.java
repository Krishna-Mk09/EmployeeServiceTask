package com.solix.com.EmployeeServiceTask.repository;

import com.solix.com.EmployeeServiceTask.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Employee findByEmail(String email);

    Employee findByEmailAndPassword(String email, String password);




}
