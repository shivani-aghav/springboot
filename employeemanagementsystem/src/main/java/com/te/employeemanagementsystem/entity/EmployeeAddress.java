package com.te.employeemanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addId;
	private String houseNo;
	private int pincode;
}
