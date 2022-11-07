package com.te.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.entity.Employee;
import com.te.springboot.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping("/getById/{empId}")
	public ResponseEntity<?> getById(@PathVariable String empId) {
		if (service.getEmployee(empId) != null) {

			return new ResponseEntity<Employee>(service.getEmployee(empId), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Id not Found", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Employee employee) {
		if (service.register(employee) != null) {
			log.debug("developer");
			return new ResponseEntity<Employee>(service.register(employee), HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<?> delete(@PathVariable String empId) {
		if (service.deleteEmployee(empId)) {
			return new ResponseEntity<String>("Account deleted succesfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getAllEmployee")
	public ResponseEntity<?> getAllEmployee() {
		if (service.getAllEmployee() != null) {
			return new ResponseEntity<List<Employee>>(service.getAllEmployee(), HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_REQUEST);
	}

//	@PostMapping("/update")
//	public ResponseEntity<?> update(@RequestBody String empId) {
//		if(service.update(empId) != null) {
//			return new ResponseEntity<String>(service.register(null))
//					
//		}
//		
//		return null;
}
