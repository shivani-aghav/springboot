package com.te.springboot.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springboot.dao.EmployeeDAO;
import com.te.springboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	
	private int i;
	LocalDateTime myDateObj = LocalDateTime.now();
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMyy");

	@Override
	public Employee getEmployee(String empId) {
		return dao.findByEmpId(empId);
	}

	@Override
	public Employee register(Employee employee) {
		dao.save(employee);
		i = employee.getId();
		employee.setEmpId("TYC" + myDateObj.format(myFormatObj) + String.format("%03d", i));
		return dao.save(employee);
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) dao.getAllEmployees();
	}

	@Override
	public void deleteById(String empId) {
		dao.deleteById(empId);
	}

	@Override
	public Employee update(Employee employee) {
		return dao.save(employee);
	}

}
