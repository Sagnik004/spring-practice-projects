package com.sagnikchakraborty.employeemgmt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleEmpNotFoundException(
            EmployeeNotFoundException exc
    ) {
        // Create error response
        EmployeeErrorResponse errRes = new EmployeeErrorResponse();
        errRes.setStatusCode(HttpStatus.NOT_FOUND.value());
        errRes.setErrorMessage(exc.getMessage());
        errRes.setTimestamp(System.currentTimeMillis());

        // Create response entity with above error response and return it
        return new ResponseEntity<>(errRes, HttpStatus.NOT_FOUND);
    }

    // Catch all other exceptions
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleOtherExceptions(Exception exc) {
        // Create error response
        EmployeeErrorResponse errRes = new EmployeeErrorResponse();
        errRes.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errRes.setErrorMessage(exc.getMessage());
        errRes.setTimestamp(System.currentTimeMillis());

        // Create response entity with above error response and return it
        return new ResponseEntity<>(errRes, HttpStatus.BAD_REQUEST);
    }
}
