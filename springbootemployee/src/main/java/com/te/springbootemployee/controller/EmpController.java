package com.te.springbootemployee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springbootemployee.entity.EmployeePrimaryInfo;
import com.te.springbootemployee.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	private EmpService service;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody EmployeePrimaryInfo primaryInfo) {
		if (service.register(primaryInfo) != null) {
			return new ResponseEntity<EmployeePrimaryInfo>(service.register(primaryInfo), HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_REQUEST);

	}
}
