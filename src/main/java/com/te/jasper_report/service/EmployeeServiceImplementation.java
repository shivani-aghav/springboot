package com.te.jasper_report.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.jasper_report.dao.EmployeeDAO;
import com.te.jasper_report.dto.EmployeeRegisterDTO;
import com.te.jasper_report.entity.Attendence;
import com.te.jasper_report.entity.Employee;
import com.te.jasper_report.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	private int i;
	LocalDateTime myDateObj = LocalDateTime.now();
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMyy");

	@Override
	public EmployeeRegisterDTO register(EmployeeRegisterDTO dto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(dto, employee);
		dao.save(employee);
		i = employee.getId();
		employee.setEmployeeId("TYC" + myDateObj.format(myFormatObj) + String.format("%03d", i));
		List<Attendence> attendence = employee.getAttendence();
		for (Attendence attendence2 : attendence) {
			attendence2.setEmployee(employee);
		}
		
		Employee save = dao.save(employee);
		
		
		BeanUtils.copyProperties(save,dto);
		return dto;
	}

	@Override
	public String delete(String id) {
		Employee findByEmpId = dao.findByEmployeeId(id);
		if (findByEmpId == null) {
			throw new EmployeeNotFoundException("data not found to delete");
		}
		dao.save(findByEmpId);
		return findByEmpId.getEmpName() + " ,record deleted succesfully";
	}

	@Override
	public EmployeeRegisterDTO update(EmployeeRegisterDTO dto) {
		Employee findByEmpId = dao.findByEmployeeId(dto.getEmployeeId());
		if (findByEmpId != null) {
				BeanUtils.copyProperties(dto, findByEmpId);
				dao.save(findByEmpId);
				BeanUtils.copyProperties(findByEmpId, dto);
				return dto;
		}
		throw new EmployeeNotFoundException("Invalid Employee Id !!");
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> findAll = dao.findAll();
//		List<Employee> collect = findAll.stream().filter((emp) -> emp.isDeleted() == false)
//				.collect(Collectors.toList());
		return findAll;
	}

}
