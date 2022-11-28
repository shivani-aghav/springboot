package com.te.employeemanagementsystem.exception;

public class EmployeeNotFoundException extends RuntimeException{

	private String message;

	public EmployeeNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}