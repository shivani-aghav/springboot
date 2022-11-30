package com.te.jasper_report.dto;

import java.util.List;

import com.te.jasper_report.entity.Attendence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegisterDTO {

	private String employeeId;
	private String empName;
	private List<Attendence> attendence;
}
