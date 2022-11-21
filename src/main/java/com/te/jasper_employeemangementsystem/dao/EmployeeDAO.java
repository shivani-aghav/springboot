package com.te.jasper_employeemangementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.jasper_employeemangementsystem.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

	Employee findByEmployeeId(String employeeId);
}
