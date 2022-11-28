package com.te.jasper_employeemangementsystem.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.jasper_employeemangementsystem.dao.CompanyDAO;
import com.te.jasper_employeemangementsystem.dao.EmployeeDAO;
import com.te.jasper_employeemangementsystem.dto.EmployeeRegisterDTO;
import com.te.jasper_employeemangementsystem.entity.CompanyDetails;
import com.te.jasper_employeemangementsystem.entity.Employee;
import com.te.jasper_employeemangementsystem.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Autowired
	private CompanyDAO companyDAO;
	
	private int i;
	LocalDateTime myDateObj = LocalDateTime.now();
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMyy");

	@Override
	public EmployeeRegisterDTO register(EmployeeRegisterDTO dto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(dto, employee);
		if (dto == null) {
			throw new EmployeeNotFoundException("no data found to register");
		}
		CompanyDetails findByCompanyDetailss = companyDAO.findByCompanyDetailss(dto.getCompany().getCompanyDetailss());
		if(findByCompanyDetailss!=null) {
			employee.setCompany(findByCompanyDetailss);
		}
		dao.save(employee);
		i = employee.getId();
		employee.setEmployeeId("TYC" + myDateObj.format(myFormatObj) + String.format("%03d", i));
		employee.setStatus(dto.getStatus().name());
//		if (dto.getGender().equals("F")) {
//			employee.setFatherName("D/O " + dto.getFatherName());
//		} else {
//			employee.setFatherName("S/O " + dto.getFatherName());
//		}
		employee.getCompany().setEmployeeId(employee.getEmployeeId());
//        CompanyDetails details = companyDAO.findByCompanyDetailss(dto.getCompany().getCompanyDetailss());
//        if (details==null) {
//        	employee.setCompany(details);
//		}
//		companyDAO.save(details);
		Employee save = dao.save(employee);
//		BeanUtils.copyProperties(save, dto);
		return dto;
	}

	@Override
	public String delete(String id) {
		Employee findByEmpId = dao.findByEmployeeId(id);
		if (findByEmpId == null) {
			throw new EmployeeNotFoundException("data not found to delete");
		}
		System.out.println("before save");
		findByEmpId.setDeleted(true);
		dao.save(findByEmpId);
		System.out.println("aft save");
		return findByEmpId.getEmpName() + " ,record deleted succesfully";
	}

	@Override
	public EmployeeRegisterDTO update(EmployeeRegisterDTO dto) {
		Employee findByEmpId = dao.findByEmployeeId(dto.getEmployeeId());
		if (findByEmpId != null) {
			if (findByEmpId.isDeleted() == false) {
				BeanUtils.copyProperties(dto, findByEmpId);
//				if (dto.getGender().equals("F")) {
//					findByEmpId.setFatherName("D/O " + dto.getFatherName());
//				} else {
//					findByEmpId.setFatherName("S/O " + dto.getFatherName());
//				}
				dao.save(findByEmpId);
				BeanUtils.copyProperties(findByEmpId, dto);
				return dto;
			}
		}
		throw new EmployeeNotFoundException("Invalid Employee Id !!");
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> findAll = dao.findAll();
		List<Employee> collect = findAll.stream().filter((emp) -> emp.isDeleted() == false)
				.collect(Collectors.toList());
		return collect;
	}

}
