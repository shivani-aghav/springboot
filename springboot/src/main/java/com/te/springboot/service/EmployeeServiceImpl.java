package com.te.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springboot.dao.EmployeeDao;
import com.te.springboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Override
	public Employee getEmployee(String empId) {
		return dao.findByEmpId(empId);
	}

	@Override
	public Employee register(Employee employee) {
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
