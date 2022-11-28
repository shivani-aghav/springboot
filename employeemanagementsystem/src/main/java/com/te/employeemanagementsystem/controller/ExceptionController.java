package com.te.employeemanagementsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.employeemanagementsystem.dto.ResponseDTO;
import com.te.employeemanagementsystem.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ResponseDTO> exceptionHandler(EmployeeNotFoundException employeeNotPresentException) {
		
		return new ResponseEntity<>(new ResponseDTO(false,employeeNotPresentException.getMessage(),null),
				HttpStatus.BAD_REQUEST);
	}
}
