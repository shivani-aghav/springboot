package com.te.springbootemployeemapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.springbootemployeemapp.entity.EmployeePrimaryInfo;

public interface EmpDao extends CrudRepository<EmployeePrimaryInfo, String>{

	public EmployeePrimaryInfo findByEmpId(String empId);

//	@Query("from EmployeePrimaryInfo")
//	public EmployeePrimaryInfo findAllById(String empId);
}
