package com.te.jasper_employeemangementsystem.service;

import java.util.List;

import com.te.jasper_employeemangementsystem.dto.EmployeeRegisterDTO;
import com.te.jasper_employeemangementsystem.entity.Employee;

public interface EmployeeService {

	EmployeeRegisterDTO register(EmployeeRegisterDTO dto);

	String delete(String id);

	EmployeeRegisterDTO update(EmployeeRegisterDTO dto);

	List<Employee> getAll();
}
