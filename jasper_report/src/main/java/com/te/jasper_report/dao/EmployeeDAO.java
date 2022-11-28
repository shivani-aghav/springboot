package com.te.jasper_report.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.jasper_report.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

	Employee findByEmployeeId(String employeeId);
	
}
