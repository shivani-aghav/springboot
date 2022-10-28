package com.te.employeemanagementsystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee-primary-info")
public class Employee implements Serializable {

	@Id
	@Column(name = "eId")
	private String empId;

	@Column(name = "ename")
	private String empName;

	@Column(name = "email")
	private String emailId;

	@Column(name = "pswd")
	private String password;

}
