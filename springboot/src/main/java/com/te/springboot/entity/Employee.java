package com.te.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {

	@Id
	private String empId;
	private String empName;
	private String empPassword;
	private String emailId;
	
}
