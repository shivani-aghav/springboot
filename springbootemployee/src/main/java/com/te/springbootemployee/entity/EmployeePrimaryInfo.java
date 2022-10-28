package com.te.springbootemployee.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class EmployeePrimaryInfo {

	@Id
	private Integer empId;
	private String empName;
	private String empAge;
	private String emailId;
	private String password;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "primaryInfo")
	private EmployeeSecondaryInfo secondaryInfo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "primaryInfo")
	private List<EmployeeEducationalDetails> educationalDetails;
}
