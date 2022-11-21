package com.te.jasper_employeemangementsystem.dto;

import java.time.LocalDateTime;

import com.te.jasper_employeemangementsystem.entity.Address;
import com.te.jasper_employeemangementsystem.entity.EStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegisterDTO {

	private String employeeId;
	private String empName;
	private String empDesignation;
	private String email;
	private LocalDateTime doj;
	private long phoneNumber;
	private EStatus status;
	private Address address;
	private String gender;
	private String fatherName;
}
