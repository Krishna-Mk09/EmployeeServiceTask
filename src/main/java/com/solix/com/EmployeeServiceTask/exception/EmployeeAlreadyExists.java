package com.solix.com.EmployeeServiceTask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Employee already exists")
public class EmployeeAlreadyExists extends Exception {
}
