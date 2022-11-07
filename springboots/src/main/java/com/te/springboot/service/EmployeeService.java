package com.te.springboot.service;

import java.util.List;

import com.te.springboot.entity.Employee;

public interface EmployeeService {
	public Employee getEmployee(String empId);

	public Employee register(Employee employee);

	public boolean deleteEmployee(String empId);

	public List<Employee> getAllEmployee();

	public Employee login(Employee employee);

	public Employee update(String empId);
}
