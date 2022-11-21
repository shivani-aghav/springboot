package com.te.jasper_employeemangementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.jasper_employeemangementsystem.dto.EmployeeRegisterDTO;
import com.te.jasper_employeemangementsystem.dto.ResponseDTO;
import com.te.jasper_employeemangementsystem.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> register(@RequestBody EmployeeRegisterDTO dto) {
		return new ResponseEntity<>(new ResponseDTO(false, "Registered Successfully", service.register(dto)),
				HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<ResponseDTO> update(@RequestBody EmployeeRegisterDTO dto) {
		return new ResponseEntity<>(new ResponseDTO(false, "Updated Successfully", service.update(dto)),HttpStatus.OK);
	}

	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable String employeeId) {
		if (employeeId!=null) {
			String delete = service.delete(employeeId);
			if (delete.isEmpty()) {
				return new ResponseEntity<>(new ResponseDTO(false, "wrong ID",employeeId),
						HttpStatus.OK);
			}
			return new ResponseEntity<>(new ResponseDTO(false, delete,null),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseDTO(false, "Id is null..!",null),
				HttpStatus.OK);
	}

	
}
