package com.te.springbootemployeemapp.service;

import java.util.List;

import com.te.springbootemployeemapp.dto.EmpDto;
import com.te.springbootemployeemapp.dto.EmpDtoDelete;
import com.te.springbootemployeemapp.dto.EmpDtoRegister;
import com.te.springbootemployeemapp.entity.EmployeePrimaryInfo;

public interface EmpService {

	public EmployeePrimaryInfo register(EmpDtoRegister dtoRegister);

	public EmployeePrimaryInfo login(EmpDto dto);

	public EmployeePrimaryInfo update(EmpDtoRegister dtoRegister);

	public String delete(EmpDtoDelete dto);

	public List<EmployeePrimaryInfo> getAll();
	
	

}
