package com.ty.ems.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ty.ems.dao.EmployeeDao;
import com.ty.ems.dto.EmployeeRegisterDto;
import com.ty.ems.dto.EmployeeUpdateDto;
import com.ty.ems.dto.GetEmployeeDto;
import com.ty.ems.entity.EmployeeAddress;
import com.ty.ems.entity.EmployeeBank;
import com.ty.ems.entity.EmployeeDepartment;
import com.ty.ems.entity.EmployeePrimary;

@WebMvcTest
@RunWith(SpringRunner.class)

class ServiceTest {

	@InjectMocks
	private EmployeeServiceImplementation employeeServiceImplementation;

	@MockBean
	private EmployeeDao dao;

	
	private List<EmployeeBank> banks;
	private List<EmployeeAddress> addresses;
	private GetEmployeeDto get;
	private List<GetEmployeeDto> userList;
	private EmployeeRegisterDto dto;
	private EmployeeUpdateDto updateDto;
	private EmployeePrimary employeePrimary;

	private EmployeeDepartment department = new EmployeeDepartment(1, "name", "mag");

	
	void set() {

		banks.add(new EmployeeBank(1, "permanent", "kotak", "ifccode"));
		addresses.add(new EmployeeAddress(1, "", "", ""));
		dto = new EmployeeRegisterDto(1, "TYC11220001", "rohan", "emp@gmail.com", "1234567", "7588376183", banks,
				addresses, department);
		updateDto = new EmployeeUpdateDto("TYC11220001", "rohan", "emp@gmail.com", "1234567", "7588376183", banks,
				addresses, department);

		userList.add(new GetEmployeeDto("1", "rohan", "emp@gmail", "123", "1234", banks, addresses, department));
	}
	
	@BeforeEach
	public void setUp() {
		// mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void findById() throws Exception {
		employeePrimary = new EmployeePrimary(1, "TYC11220001", "rohan", "emp@gmail.com", "1234567", "7588376183", banks,
				addresses, department);
		
		when(dao.findByEmployeeId("TYC11220001")).thenReturn(employeePrimary);
		GetEmployeeDto employeeByEmpId = employeeServiceImplementation.getEmployeeByEmpId("TYC11220001");
        
         assertThat(employeeByEmpId).isNotNull();
	}
	
	@Test
	public void registerTest( ) throws Exception{
		employeePrimary = new EmployeePrimary(1, "TYC11220001", "rohan", "emp@gmail.com", "1234567", "7588376183", banks,
				addresses, department);
		
		when(dao.save(employeePrimary)).thenReturn(employeePrimary);
		 EmployeeRegisterDto register = employeeServiceImplementation.register(dto);
		
         assertThat(register).isNotNull();

	}

}
