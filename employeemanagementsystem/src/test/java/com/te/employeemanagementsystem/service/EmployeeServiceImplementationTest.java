//package com.te.employeemanagementsystem.service;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.te.employeemanagementsystem.dao.EmpDAO;
//import com.te.employeemanagementsystem.dto.RegisterEmployeeDTO;
//import com.te.employeemanagementsystem.dto.UpdateEmployeeDTO;
//import com.te.employeemanagementsystem.entity.EmployeeAddress;
//import com.te.employeemanagementsystem.entity.EmployeeBankDetails;
//import com.te.employeemanagementsystem.entity.EmployeeDepartment;
//import com.te.employeemanagementsystem.entity.Employee;
//import com.te.employeemanagementsystem.exception.EmployeeNotFoundException;
//
//@SpringBootTest
//public class EmployeeServiceImplementationTest {
//
//	@Autowired
//	private EmployeeService service;
//
//	@MockBean
//	private EmpDAO dao;
//
//	@InjectMocks
//	private Employee employee;
//
//	List<Employee> employee1 = new ArrayList<>();
//	List<EmployeeBankDetails> details = new ArrayList<>();
//	List<EmployeeAddress> address1 = new ArrayList<>();
//	EmployeeBankDetails bankDetails = new EmployeeBankDetails(1, "sbi", "sbin1222", "15156163");
//	EmployeeDepartment department = new EmployeeDepartment(1, "A12");
//	EmployeeAddress address = new EmployeeAddress(1, "A12", 889988);
//
//	@BeforeEach
//	public void setUp() {
//		details.add(bankDetails);
//		address1.add(address);
//
//		employee = new Employee(1, "shivani",565677, "shiv@gmail.com", "000", "Female", "87878", address1, details,
//				department,null);
//		when(dao.findByEmpId(1)).thenReturn(employee);
//	}
//
//	@Test
//	public void testGetById() {
//		details.add(bankDetails);
//		address1.add(address);
//		employee = new Employee(1, "shivani",565677, "shiv@gmail.com", "000", "Female", "87878", address1, details,
//				department,null);
//		when(dao.findByEmpId(1)).thenReturn(employee);
//		Employee employee1 = service.getById(1);
//		String name = "shivani";
//		assertEquals(employee1.getEmpName(), name);
////		assertEquals(employee1, employee);
//	}
//
//	@Test
//	public void deleteTest() throws Exception {
//		details.add(bankDetails);
//		address1.add(address);
//
//		employee = new Employee(1, "shivani",565677, "shiv@gmail.com", "000", "Female", "87878", address1, details,
//				department,null);
//
//		Integer employeeId = 1;
//
//		when(dao.findByEmpId(1)).thenReturn(employee);
//		service.delete(employeeId);
//
//	}
//
//	@Test
//	public void deleteTestFail() {
//		details.add(bankDetails);
//
//		address1.add(address);
//
//		employee = new Employee(1, "shivani",565677, "shiv@gmail.com", "000", "Female", "87878", address1, details,
//				department,null);
//
//		Integer employeeId = 2;
//
//		when(dao.findByEmpId(2)).thenReturn(null);
//		EmployeeNotFoundException assertThrows2 = assertThrows(EmployeeNotFoundException.class,
//				() -> service.delete(employeeId));
//		System.out.println(assertThrows2);
//		String msg = "id not found ";
//		assertThat(assertThrows2.getMessage()).isEqualTo(msg);
//
//	}
//
//	@Test
//	public void getAllTest() throws Exception {
//		details.add(bankDetails);
//		address1.add(address);
//
//		employee = new Employee(1, "shivani",565677, "shiv@gmail.com", "000", "Female", "87878", address1, details,
//				department,null);
//		employee1.add(employee);
//
//		when(dao.findAll()).thenReturn(employee1);
//		service.getAll();
//		assertNotNull(employee1);
//
//	}
//
//	@Test
//	public void updateTest() throws Exception {
////		details.add(bankDetails);
////		address1.add(address);
////		employee = new Employee(1, "shivani", "shiv@gmail.com", "000", "Female", "87878", address1, details,
////				department);
//		UpdateEmployeeDTO dtoUpdate = new UpdateEmployeeDTO(1, "shivani", "shiv@gmail.com", "000", "Female", "87878", address1,
//				details, department);
////		dao.findByEmpId(1);
//		dtoUpdate.setEmail("A@gmail.com");
////		when(dao.save(employee)).thenReturn(employee);
//		UpdateEmployeeDTO update = service.update(dtoUpdate);
//
//		assertNotNull(update);
//		assertEquals(dtoUpdate, update);
//		;
//
//	}
//
//	@Test
//	public void registerTest() throws Exception {
//		details.add(bankDetails);
//		address1.add(address);
//		employee = new Employee(1, "shivani",565677, "shiv@gmail.com", "000", "Female", "87878", address1, details,
//				department,null);
//		RegisterEmployeeDTO dtoUpdate = new RegisterEmployeeDTO(1, "shivani", "shiv@gmail.com",3438, "000", "Female",null, "87878",
//				address1, details, department);
//		when(dao.save(employee)).thenReturn(employee);
//		RegisterEmployeeDTO save = service.register(dtoUpdate);
//
//		assertNotNull(save);
//		assertEquals(dtoUpdate, save);
//		;
//
//	}
//
//}
