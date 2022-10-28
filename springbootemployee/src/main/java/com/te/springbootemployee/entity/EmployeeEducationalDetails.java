package com.te.springbootemployee.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class EmployeeEducationalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sId;
	private String yop10th;
	private String yopDegree;
	private String yopDiploma;
	@ManyToOne(cascade = CascadeType.ALL)
	private EmployeePrimaryInfo primaryInfo;

}
