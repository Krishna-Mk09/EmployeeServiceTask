package com.solix.com.EmployeeServiceTask.service;
import com.solix.com.EmployeeServiceTask.domain.Employee;
import com.solix.com.EmployeeServiceTask.exception.EmployeeAlreadyExists;
import com.solix.com.EmployeeServiceTask.exception.EmployeeNotFound;
import com.solix.com.EmployeeServiceTask.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository EMPLOYEE_REPOSITORY;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        EMPLOYEE_REPOSITORY = employeeRepository;
    }

    @Override
    public Employee saveUser(Employee employee) throws EmployeeAlreadyExists {
        if (EMPLOYEE_REPOSITORY.findById(employee.getEmail()).isPresent()) {
            throw new EmployeeAlreadyExists();
        }
        return this.EMPLOYEE_REPOSITORY.save(employee);
    }

    @Override
    public void deleteEmployeeByEmail(String email) throws EmployeeNotFound {
        this.EMPLOYEE_REPOSITORY.deleteById(email);
    }

    @Override
    public Employee updateEmployeeByEmail(Employee employee, String email) {
        return this.EMPLOYEE_REPOSITORY.save(employee);
    }

    @Override
    public Employee getEmployeeByEmail(String email) throws EmployeeNotFound {
        return this.EMPLOYEE_REPOSITORY.findByEmail(email);
    }

    @Override
    public List<String> getAllEmails() {
        List<Employee> all = this.EMPLOYEE_REPOSITORY.findAll();
        List<String> emails = new ArrayList<>();
        for (Employee employee : all) {
            emails.add(employee.getEmail());
        }
        return emails;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.EMPLOYEE_REPOSITORY.findAll();
    }

    @Override
    public Employee incrementSalary(String email, int increment) throws EmployeeNotFound {
        if (!this.EMPLOYEE_REPOSITORY.findById(email).isPresent()) {
            throw new EmployeeNotFound();
        }
        Employee employee = this.EMPLOYEE_REPOSITORY.findByEmail(email);
        employee.setSalary(employee.getSalary() + (employee.getSalary() * increment) / 100);
        return this.EMPLOYEE_REPOSITORY.save(employee);

    }
}
