package com.te.employeemanagementsystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empId")
	private Integer empId;
	@NotBlank(message = "Name field is required !!")
	@Size(min = 2, max = 20, message = "min 2 and max 20 characters are allowed")
	private String empName;
	private String phoneNumber;
	private String email;
	private String password;
	private String gender;
	private String token;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "empId")
//	@JsonManagedReference
	private List<EmployeeAddress> address;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "empId")
//	@JsonManagedReference
	private List<EmployeeBankDetails> bankDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_id")
//	@JsonManagedReference
	private EmployeeDepartment dept;
	private String role;
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JsonManagedReference
//	@JoinColumn(name = "empId")
//	private List<EmployeeRoles> roles;
}
