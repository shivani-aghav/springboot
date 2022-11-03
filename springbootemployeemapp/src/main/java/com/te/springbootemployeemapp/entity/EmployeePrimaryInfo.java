package com.te.springbootemployeemapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "primaryInfo")
//	@JoinTable(name = "emp_skill", joinColumns =  @JoinColumn(name = "emp_id") , inverseJoinColumns = 
//    @JoinColumn(name = "sk_id"))
	private List<EmpSkills> skills;

}
