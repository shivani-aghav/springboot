package com.te.jasper_report.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.jasper_report.dto.ResponseDTO;
import com.te.jasper_report.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> exceptionHandler(EmployeeNotFoundException employeeNotPresentException) {
		
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(false,employeeNotPresentException.getMessage(),null),HttpStatus.BAD_REQUEST);
	}
}
