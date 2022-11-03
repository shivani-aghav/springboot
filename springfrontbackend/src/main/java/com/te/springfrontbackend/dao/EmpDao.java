package com.te.springfrontbackend.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.te.springfrontbackend.entity.Employee;

public interface EmpDao extends CrudRepository<Employee, String> {

	public Employee findByEmpId(String empId);



}
