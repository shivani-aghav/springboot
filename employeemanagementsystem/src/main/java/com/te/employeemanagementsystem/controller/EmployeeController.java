package com.te.employeemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.employeemanagementsystem.dto.LoginDTO;
import com.te.employeemanagementsystem.dto.RegisterEmployeeDTO;
import com.te.employeemanagementsystem.dto.UpdateEmployeeDTO;
import com.te.employeemanagementsystem.dto.ResponseDTO;
import com.te.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.te.employeemanagementsystem.service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@AllArgsConstructor
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> register(@RequestBody RegisterEmployeeDTO dtoRegister) {
		try {
			log.info("registration api");
			return new ResponseEntity<ResponseDTO>(
					new ResponseDTO(true, "registerd successfully", service.register(dtoRegister)), HttpStatus.OK);

		} catch (Exception e) {
			throw new EmployeeNotFoundException("not able to register");
		}
	}

	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO login) throws Throwable {
		String token=service.login(login);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(true, "Login Successful !!", token),HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody UpdateEmployeeDTO update) {
		try {
			log.info("update api");
			return new ResponseEntity<>(
					new ResponseDTO(true, "updated successfully", service.update(update)), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(false, "update failed", service.update(update)),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		try {
			log.info("getAll api");
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(true, "data found", service.getAll()),
					HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Not able to get data!", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/getById/{empId}")
	public ResponseEntity<ResponseDTO> getById(@PathVariable Integer empId) {
		log.info("getById api");
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(true, "data found", service.getById(empId)),
				HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<?> delete(@PathVariable Integer empId) {
		log.info("delete api");
		service.delete(empId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(true, "record deleted", null), HttpStatus.OK);
	}
}
