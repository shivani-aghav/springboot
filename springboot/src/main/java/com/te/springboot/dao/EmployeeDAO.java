package com.te.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.te.springboot.entity.Employee;

public interface EmployeeDAO extends CrudRepository<Employee, String> {

	public Employee findByEmpId(String empId);

	@Query("from Employee")
	public List<Employee> getAllEmployees();
}
