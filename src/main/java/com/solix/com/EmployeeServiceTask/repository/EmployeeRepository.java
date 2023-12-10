package com.solix.com.EmployeeServiceTask.repository;
import com.solix.com.EmployeeServiceTask.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Employee findByEmail(String email);

    Employee findByEmailAndPassword(String email, String password);

}
