//package com.te.employeemanagementsystem.controller;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.te.employeemanagementsystem.dto.RegisterEmployeeDTO;
//import com.te.employeemanagementsystem.dto.ResponseDTO;
//import com.te.employeemanagementsystem.dto.UpdateEmployeeDTO;
//import com.te.employeemanagementsystem.entity.Employee;
//import com.te.employeemanagementsystem.entity.EmployeeAddress;
//import com.te.employeemanagementsystem.entity.EmployeeBankDetails;
//import com.te.employeemanagementsystem.entity.EmployeeDepartment;
//import com.te.employeemanagementsystem.service.EmployeeService;
//
//@WebMvcTest
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = EmployeeController.class)
//class EmployeeControllerTest {
//
////	@Autowired()
////	private MockMvc mockMvc;
//
//	@MockBean
//	private EmployeeService service;
//
//	@InjectMocks
//	private EmployeeController controller;
////	@Autowired
////	private ObjectMapper mapper;
//
//	@Autowired
//	private WebApplicationContext context;
//
//	private List<EmployeeBankDetails> banks;
//	private List<EmployeeAddress> addresses;
////	private GetEmployeeDto get;
//	private List<Employee> userList;
//	private RegisterEmployeeDTO dto;
//	private UpdateEmployeeDTO updateDto;
//	
//	
//
//	private EmployeeDepartment department = new EmployeeDepartment(1, "A12");
//
//	
//	void set() {
//
//		banks.add(new EmployeeBankDetails(1, "sbi", "sbin1222", "15156163"));
//		addresses.add(new EmployeeAddress(1, "A12", 889988));
//		dto = new RegisterEmployeeDTO(1, "shivani", "shiv@gmail.com",022772737, "000", "Female",null, "87878", addresses, banks,
//				department);
//		updateDto = new UpdateEmployeeDTO(1, "shivani", "shiv@gmail.com", "000", "Female", "87878", addresses, banks,
//				department);
//
//		userList.add(new Employee(1, "shivani",42828399, "shiv@gmail.com", "000", "Female", "87878", addresses, banks,
//				department,null));
//	}
//
//	@BeforeEach
//	public void setUp() {
//		// mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//
//		MockitoAnnotations.initMocks(this);
//
//	}
//
//	// Test Cases For Controller
//
//	// Test Cases For Register
//	@Test
//	public void testRegsiter() throws Exception {
//		when(service.register(dto)).thenReturn(dto);
//		ResponseEntity<ResponseDTO> emp = controller.register(dto);
//		assertNotNull(emp);
//		assertEquals(HttpStatus.OK, emp.getStatusCode());
//
//	}
//
//	@Test
//	public void testUpdate() throws Exception{
//		when(service.update(updateDto)).thenReturn(updateDto);
//		ResponseEntity<?> update = controller.update(updateDto);
//		assertNotNull(update);
//		assertEquals(HttpStatus.OK,update.getStatusCode());
//	}
//
//	@Test
//	void testGetById() throws Exception {
//
//		Employee employee = new Employee(1, "shivani",42828399, "shiv@gmail.com", "000", "Female",null, addresses, banks,
//				department,null);
//		when(service.getById(1)).thenReturn(employee);
//		ResponseEntity<ResponseDTO> emp = controller.getById(employee.getEmpId());
//		assertNotNull(emp);
//		assertEquals(HttpStatus.OK, emp.getStatusCode());
//
//	}
//
////	@Test
////	void testGetAll() throws Exception {
////
////		when(employeeServiceImplementation.get()).thenReturn(userList);
////		ResponseEntity<ResponseDto> emp = controller.getAll();
////		assertNotNull(emp);
////		assertEquals(HttpStatus.OK, emp.getStatusCode());
////	}
////
////	@Test
////	void testDelete() throws Exception {
////
////		get = new GetEmployeeDto("1", "rohan", "mailto:emp@gmail.com", "12345678", "7588376183", banks, addresses, department);
////		when(employeeServiceImplementation.delete(anyString())).thenReturn(true);
////		ResponseEntity<ResponseDto> emp = controller.delete(anyString());
////		assertEquals(HttpStatus.OK, emp.getStatusCode());
////	}
//}
//
