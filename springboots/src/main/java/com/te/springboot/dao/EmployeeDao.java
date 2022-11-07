package com.te.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.springboot.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee, String> {
	public Employee findByEmpId(String empId);

//	@Query("from Employee where empName like '%k' ")
//	public Employee getAllemployee();
}

