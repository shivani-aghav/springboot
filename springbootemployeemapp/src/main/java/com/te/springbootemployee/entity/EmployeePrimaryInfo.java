package com.te.springbootemployee.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class EmployeePrimaryInfo {

	@Id
	private String empId;
	private String empName;
	private String empAge;
	private String emailId;
	private String password;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "primaryInfo")
	@JsonManagedReference
	private EmployeeSecondaryInfo secondaryInfo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "primaryInfo")
	@JsonManagedReference
	private List<EmployeeEducationalDetails> educationalDetails;
}
