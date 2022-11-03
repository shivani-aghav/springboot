package com.te.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.entity.Employee;
import com.te.springboot.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/springboot")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;

	@GetMapping(path = ("/getById/{empId}"))
	public ResponseEntity<?> getById(@PathVariable String empId) {
		if (service.getEmployee(empId) != null) {
			return new ResponseEntity<Employee>(service.getEmployee(empId), HttpStatus.OK);
		}
		return new ResponseEntity<String>("Id not Found", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Employee employee) {
		if (service.register(employee) != null) {
			return new ResponseEntity<String>("data entered successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllEmp() {
		if (service.getAllEmployees() != null) {
			return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/deleteId/{empId}")
	public ResponseEntity<?> deleteById(@PathVariable String empId) {
		try {
			service.deleteById(empId);
			return new ResponseEntity<String>("Record Deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Employee employee) {
		if (service.update(employee) != null) {
			return new ResponseEntity<String>("data updated", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_REQUEST);
	}
}
