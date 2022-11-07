package com.te.springboot.service;

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
	public Employee register(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public boolean deleteEmployee(String empId) {
		boolean isDeleted = false;
		try {
			dao.deleteById(empId);
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return (List<Employee>) dao.findAll();
	}

	@Override
	public Employee login(Employee employee) {
		return null;
	}
//
//	@Override
//	public Employee update(String empId) {
//		return dao.saveAll(empId);
//	}

	@Override
	public Employee getEmployee(String empId) {
		// TODO Auto-generated method stub
		return dao.findByEmpId(empId);
	}

	@Override
	public Employee update(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

}
