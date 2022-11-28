package com.te.jasper_report.service;

import java.util.List;

import com.te.jasper_report.dto.EmployeeRegisterDTO;
import com.te.jasper_report.entity.Employee;

public interface EmployeeService {

	EmployeeRegisterDTO register(EmployeeRegisterDTO dto);

	String delete(String id);

	EmployeeRegisterDTO update(EmployeeRegisterDTO dto);

	List<Employee> getAll();
}
