package com.te.springfrontbackend.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springfrontbackend.dao.EmpDao;
import com.te.springfrontbackend.dto.EmpDto;
import com.te.springfrontbackend.dto.EmpLoginDto;
import com.te.springfrontbackend.entity.Employee;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmpDao dao;

	@Override
	public EmpDto register(EmpDto dto) {
		Employee map = this.modelMapper.map(dto, Employee.class);
		dao.save(map);
		return this.modelMapper.map(map, EmpDto.class);
	}

	@Override
	public EmpLoginDto login(EmpLoginDto loginDto) {
		Employee map = this.modelMapper.map(loginDto, Employee.class);
		Employee byEmpId = dao.findByEmpId(map.getEmpId());
		return this.modelMapper.map(byEmpId, EmpLoginDto.class);
	}

	@Override
	public List<Employee> getAll() {		
		return (List<Employee>) dao.findAll();
	}
	
	

}
