package com.te.employeemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.employeemanagementsystem.dao.EmployeeDao;
import com.te.employeemanagementsystem.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public boolean register(Employee employee) {
		if(employee.getEmpId().startsWith("TYC")) {
			return employeeDao.registerDao(employee);
		}
		return false;
	}

}
