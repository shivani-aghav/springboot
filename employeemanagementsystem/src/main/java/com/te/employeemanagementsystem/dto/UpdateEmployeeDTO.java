package com.te.employeemanagementsystem.dto;

import java.util.List;

import com.te.employeemanagementsystem.entity.EmployeeAddress;
import com.te.employeemanagementsystem.entity.EmployeeBankDetails;
import com.te.employeemanagementsystem.entity.EmployeeDepartment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeDTO {

	private Integer empId;
	private String empName;
	private String email;
	private String password;
	private String gender;
	private String token;
	
	private List<EmployeeAddress> address;
	private List<EmployeeBankDetails> bankDetails;
	private EmployeeDepartment dept;
	
}
