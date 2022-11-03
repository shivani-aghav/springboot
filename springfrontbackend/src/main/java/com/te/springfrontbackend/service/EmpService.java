package com.te.springfrontbackend.service;

import java.util.List;

import com.te.springfrontbackend.dto.EmpDto;
import com.te.springfrontbackend.dto.EmpLoginDto;
import com.te.springfrontbackend.entity.Employee;

public interface EmpService {

	public EmpDto register(EmpDto dto);

	public EmpLoginDto login(EmpLoginDto loginDto);

	public List<Employee> getAll();

}
