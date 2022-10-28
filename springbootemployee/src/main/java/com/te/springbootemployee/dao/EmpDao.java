package com.te.springbootemployee.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.springbootemployee.entity.EmployeePrimaryInfo;

public interface EmpDao extends CrudRepository<EmployeePrimaryInfo, String>{

}
