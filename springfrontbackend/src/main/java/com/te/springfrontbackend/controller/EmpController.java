package com.te.springfrontbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springfrontbackend.dto.EmpDto;
import com.te.springfrontbackend.dto.EmpLoginDto;
import com.te.springfrontbackend.dto.ResponseDto;
import com.te.springfrontbackend.service.EmpService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmpController {

	@Autowired
	private EmpService service;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody EmpDto dto) {
		try {
			return new ResponseEntity<ResponseDto>(
					new ResponseDto("registerd successfully", true, service.register(dto)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody EmpLoginDto loginDto) {
		try {
			return new ResponseEntity<ResponseDto>(new ResponseDto("logged in", true, service.login(loginDto)),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		try {
			return new ResponseEntity<ResponseDto>(new ResponseDto("found all data",true, service.getAll()),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("something went wrong!", HttpStatus.BAD_REQUEST);
		}
	}
}
