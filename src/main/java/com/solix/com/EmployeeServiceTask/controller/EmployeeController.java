package com.solix.com.EmployeeServiceTask.controller;
import com.solix.com.EmployeeServiceTask.domain.Employee;
import com.solix.com.EmployeeServiceTask.exception.EmployeeAlreadyExists;
import com.solix.com.EmployeeServiceTask.exception.EmployeeNotFound;
import com.solix.com.EmployeeServiceTask.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService EMPLOYEE_SERVICE;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        EMPLOYEE_SERVICE = employeeService;
    }


    //   http://localhost:8088/api/v1/employees/add
    @PostMapping("/add")
    public ResponseEntity<?> savesEmployee(@RequestBody Employee employee) throws EmployeeAlreadyExists {
        try {
            return new ResponseEntity<>(this.EMPLOYEE_SERVICE.saveUser(employee), HttpStatus.CREATED);
        } catch (EmployeeAlreadyExists ec) {
            throw new EmployeeAlreadyExists();
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<?> deletesUser(@PathVariable String email) throws EmployeeNotFound {
        this.EMPLOYEE_SERVICE.deleteEmployeeByEmail(email);
        return new ResponseEntity<>("user deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/update/{email}")
    public ResponseEntity<?> updatesUser(@RequestBody Employee employee, @PathVariable String email) {
        this.EMPLOYEE_SERVICE.updateEmployeeByEmail(employee, email);
        return new ResponseEntity<>("updated  successfully", HttpStatus.OK);
    }

    @GetMapping(path = "/get/{email}",consumes = "application/json")
    public ResponseEntity<?> getsUser(@PathVariable String email) throws EmployeeNotFound {
        return new ResponseEntity<>(this.EMPLOYEE_SERVICE.getEmployeeByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllEmails() {
        return new ResponseEntity<>(this.EMPLOYEE_SERVICE.getAllEmails(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/all/employees",produces = "application/xml")
    public ResponseEntity<?> getAllEmployees() {
        return new ResponseEntity<>(this.EMPLOYEE_SERVICE.getAllEmployees(), HttpStatus.OK);
    }

    @PutMapping("/increment/{email}/{increment}")
    public ResponseEntity<?> incrementSalary(@PathVariable String email, @PathVariable int increment) throws EmployeeNotFound {
        return new ResponseEntity<>(this.EMPLOYEE_SERVICE.incrementSalary(email, increment), HttpStatus.OK);
    }

}
