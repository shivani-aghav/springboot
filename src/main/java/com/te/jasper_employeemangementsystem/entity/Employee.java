package com.te.jasper_employeemangementsystem.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String employeeId;
	private String empName;
	private String empDesignation;
	private String email;
	private LocalDateTime doj;
	private long phoneNumber;
	private boolean isDeleted;
	private String status;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Address address;
	private String gender;
	private String fatherName;

	@ManyToOne
	@Cascade(CascadeType.ALL)
	private CompanyDetails company;
}
