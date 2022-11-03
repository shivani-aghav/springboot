package com.te.springbootemployeemapp.dto;

import java.util.List;

import com.te.springbootemployeemapp.entity.EmpSkills;
import com.te.springbootemployeemapp.entity.EmployeeEducationalDetails;
import com.te.springbootemployeemapp.entity.EmployeeSecondaryInfo;

import lombok.Data;

@Data
public class EmpDtoRegister {
	private String empId;
	private String empName;
	private String empAge;
	private String emailId;
	private String password;

	private EmployeeSecondaryInfo secondaryInfo;
	private List<EmployeeEducationalDetails> educationalDetails;
	private List<EmpSkills> skills;
}
