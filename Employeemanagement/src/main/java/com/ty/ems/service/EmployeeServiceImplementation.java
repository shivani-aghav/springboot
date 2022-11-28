package com.ty.ems.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.ems.dao.EmployeeDao;
import com.ty.ems.dto.EmployeeRegisterDto;
import com.ty.ems.dto.EmployeeUpdateDto;
import com.ty.ems.dto.GetEmployeeDto;
import com.ty.ems.email.EmailConfig;
import com.ty.ems.entity.EmployeePrimary;
import com.ty.ems.exception.EmployeeException;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	EmployeeDao dao;

	@Autowired
	EmailConfig config;

	private int i;
	LocalDateTime myDateObj = LocalDateTime.now();
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMyy");

	@Override
	public EmployeeRegisterDto register(EmployeeRegisterDto dto) {
		try {
			EmployeePrimary empObj = new EmployeePrimary();

			BeanUtils.copyProperties(dto, empObj);
			dao.save(empObj);
			i = empObj.getId();
			empObj.setEmployeeId("TYC" + myDateObj.format(myFormatObj) + String.format("%04d", i));
			dao.save(empObj);

			BeanUtils.copyProperties(empObj, dto);

			return dto;

		} catch (Exception e) {
			e.printStackTrace();
			throw new EmployeeException("Something Went Wrong");
		}

	}
	
	@Override
	public EmployeeUpdateDto update(EmployeeUpdateDto dto) {

		System.out.println("@@@@@@@@@@@@@@@start");
		EmployeePrimary empObj = dao.findByEmployeeId(dto.getEmployeeId());

		if (empObj != null) {
			System.out.println("@@@@@@@@@@@@@@@loop");

			BeanUtils.copyProperties(dto, empObj);
			dao.save(empObj);
//			GetEmployeeDto getEmployeeDto = new GetEmployeeDto();
			BeanUtils.copyProperties(empObj, dto);

			return dto;
		} else {
			System.out.println("@@@@@@@@@@@@@@@ed" + empObj);
			throw new EmployeeException("Id Not Found");

		}
	}

	@Override
	public boolean delete(String empId) {

		if (dao.findByEmployeeId(empId) != null) {
			EmployeePrimary findByEmpId = dao.findByEmployeeId(empId);
			dao.delete(findByEmpId);
			return true;
		}
		throw new EmployeeException("Id Not Found");

	}

	@Override
	public GetEmployeeDto getEmployeeByEmpId(String empId) {

		if (dao.findByEmployeeId(empId) != null) {
			EmployeePrimary findByEmpId = dao.findByEmployeeId(empId);

			GetEmployeeDto getEmployeeDto = new GetEmployeeDto(findByEmpId.getEmployeeId(), findByEmpId.getEmpName(),
					findByEmpId.getEmpEmail(), findByEmpId.getPassword(), findByEmpId.getPhoneNumber(),
					findByEmpId.getBanks(), findByEmpId.getAddresses(), findByEmpId.getDepartments());

			return getEmployeeDto;
		}
		throw new EmployeeException("Id Not Found");
	}

	@Override
	public List<GetEmployeeDto> get() {

		// to store all data
		List<EmployeePrimary> findAll = dao.findAll();

		// for coping all data
		List<GetEmployeeDto> dtos = new ArrayList<>();

		for (EmployeePrimary findByEmpId : findAll) {
			GetEmployeeDto employeeRegisterDto = new GetEmployeeDto(findByEmpId.getEmployeeId(),
					findByEmpId.getEmpName(), findByEmpId.getEmpEmail(), findByEmpId.getPassword(),
					findByEmpId.getPhoneNumber(), findByEmpId.getBanks(), findByEmpId.getAddresses(),
					findByEmpId.getDepartments());
			dtos.add(employeeRegisterDto);

		}

		return dtos;

	}

	@Override
	public List<GetEmployeeDto> getEmployeeByName(String empName) {

		List<EmployeePrimary> findAll = dao.findByEmpName(empName);

		List<GetEmployeeDto> dtos = new ArrayList<>();

		for (EmployeePrimary findByEmpId : findAll) {
			GetEmployeeDto employeeRegisterDto = new GetEmployeeDto(findByEmpId.getEmployeeId(),
					findByEmpId.getEmpName(), findByEmpId.getEmpEmail(), findByEmpId.getPassword(),
					findByEmpId.getPhoneNumber(), findByEmpId.getBanks(), findByEmpId.getAddresses(),
					findByEmpId.getDepartments());
			dtos.add(employeeRegisterDto);

		}
		return dtos;
	}
}
