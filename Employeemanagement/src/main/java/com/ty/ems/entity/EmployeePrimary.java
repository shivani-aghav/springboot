package com.ty.ems.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_management_project")
public class EmployeePrimary {

	

//	@GenericGenerator(name = "empnextId", strategy = "com.ty.ems.controller.idgenerator.IdGenerator", parameters = {
//			@Parameter(name = IdGenerator.INCREMENT_PARAM, value = "1"),
//			@Parameter(name = IdGenerator.VALUE_PREFIX_PARAMETER, value = "TYC"),
//			@Parameter(name = IdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	private String employeeId;

	private String empName;
	private String empEmail;
	private String password;
	@Column(name = "phone_number")
	private String phoneNumber;

	// one to many unidirectional mapping
	@OneToMany(cascade = CascadeType.ALL )
	@JoinColumn(name = "Id",nullable = false)
	@JsonIgnore
	private List<EmployeeBank> banks;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id",nullable = false)
	@JsonIgnore
	private List<EmployeeAddress> addresses;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id",nullable = false)
	@JsonIgnore
	private EmployeeDepartment departments;

}
