package com.solix.com.EmployeeServiceTask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "user name not found")
public class EmployeeNotFound extends Exception {
}
