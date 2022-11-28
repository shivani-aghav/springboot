package com.te.employeemanagementsystem.service;

import java.util.List;

import com.te.employeemanagementsystem.dto.LoginDTO;
import com.te.employeemanagementsystem.dto.RegisterEmployeeDTO;
import com.te.employeemanagementsystem.dto.UpdateEmployeeDTO;
import com.te.employeemanagementsystem.entity.Employee;

public interface EmployeeService {

	RegisterEmployeeDTO register(RegisterEmployeeDTO dtoRegister);

	List<Employee> getAll();

	UpdateEmployeeDTO update(UpdateEmployeeDTO update);

	void delete(Integer empId);

	Employee getById(Integer empId);

	String login(LoginDTO login);

}
