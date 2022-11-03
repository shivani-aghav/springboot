package com.te.springbootemployeemapp.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springbootemployeemapp.dao.EmpDao;
import com.te.springbootemployeemapp.dto.EmpDto;
import com.te.springbootemployeemapp.dto.EmpDtoDelete;
import com.te.springbootemployeemapp.dto.EmpDtoRegister;
import com.te.springbootemployeemapp.entity.EmpSkills;
import com.te.springbootemployeemapp.entity.EmployeeEducationalDetails;
import com.te.springbootemployeemapp.entity.EmployeePrimaryInfo;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDao dao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmployeePrimaryInfo register(EmpDtoRegister dtoRegister) {
		EmployeePrimaryInfo register = this.modelMapper.map(dtoRegister, EmployeePrimaryInfo.class);
		register.getSecondaryInfo().setPrimaryInfo(register);
		for (EmployeeEducationalDetails detail : dtoRegister.getEducationalDetails()) {
			detail.setPrimaryInfo(register);
		}
		List<EmployeePrimaryInfo> list = new ArrayList<>();
		list.add(register);
		
		List<EmpSkills> skills = new ArrayList<>();
		skills.addAll(register.getSkills());
		
		for (EmpSkills skil : register.getSkills()) {
			skil.setPrimaryInfo(list);
			for (EmployeePrimaryInfo info : skil.getPrimaryInfo()) {
				info.setSkills(skills);
			}
		}
	return dao.save(register);
	
	}

	@Override
	public EmployeePrimaryInfo login(EmpDto dto) {
		EmployeePrimaryInfo login = this.modelMapper.map(dto, EmployeePrimaryInfo.class);
		return dao.findByEmpId(login.getEmpId());
	}

	@Override
	public EmployeePrimaryInfo update(EmpDtoRegister dtoRegister) {
		EmployeePrimaryInfo update = this.modelMapper.map(dtoRegister, EmployeePrimaryInfo.class);
		return dao.save(update);
	}

	@Override
	public String delete(EmpDtoDelete dto) {
		EmployeePrimaryInfo delete = this.modelMapper.map(dto, EmployeePrimaryInfo.class);
		dao.deleteById(delete.getEmpId());
		return "record deleted";
	}

	@Override
	public List<EmployeePrimaryInfo> getAll() {

		return (List<EmployeePrimaryInfo>) dao.findAll();
	}

}
