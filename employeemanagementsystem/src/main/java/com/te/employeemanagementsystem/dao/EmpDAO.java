package com.te.employeemanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import com.te.employeemanagementsystem.entity.Employee;

public interface EmpDAO extends JpaRepository<Employee, Integer> {

	Employee findByEmail(String email);
	
	Employee findByEmpId(Integer id);
}
