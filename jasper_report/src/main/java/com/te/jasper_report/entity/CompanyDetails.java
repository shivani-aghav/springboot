package com.te.jasper_report.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;
	private String companyDetailss;
	private String companyLogo;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
	private List<Employee> employee;
	private String employeeId;
}
