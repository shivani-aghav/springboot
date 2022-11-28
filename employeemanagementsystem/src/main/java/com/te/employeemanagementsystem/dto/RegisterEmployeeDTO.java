package com.te.employeemanagementsystem.dto;

import java.util.List;

import com.te.employeemanagementsystem.entity.EmployeeAddress;
import com.te.employeemanagementsystem.entity.EmployeeBankDetails;
import com.te.employeemanagementsystem.entity.EmployeeDepartment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RegisterEmployeeDTO {

	private Integer empId;
	private String empName;
	private String email;
	private String phoneNumber;
	private String password;
	private String gender;
	private String token;
	private String role;
	
	private List<EmployeeAddress> address;
	private List<EmployeeBankDetails> bankDetails;
	private EmployeeDepartment dept;

}
