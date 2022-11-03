package com.te.springbootemployeemapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;


@Entity
@Data
public class EmployeeEducationalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sId;
	private String yop;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private EmployeePrimaryInfo primaryInfo;

}
