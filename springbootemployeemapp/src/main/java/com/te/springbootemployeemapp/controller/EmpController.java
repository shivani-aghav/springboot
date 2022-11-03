package com.te.springbootemployeemapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springbootemployeemapp.dto.EmpDto;
import com.te.springbootemployeemapp.dto.EmpDtoDelete;
import com.te.springbootemployeemapp.dto.EmpDtoRegister;
import com.te.springbootemployeemapp.dto.ResponseDto;
import com.te.springbootemployeemapp.service.EmpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EmpController {

	@Autowired
	private EmpService service;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody EmpDtoRegister dtoRegister) {
		if(service.register(dtoRegister)!=null){
			log.info("working");
			return new ResponseEntity<ResponseDto>(
					new ResponseDto(true, "registered succesful", service.register(dtoRegister)), HttpStatus.OK);
		} else {
			
			return new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody EmpDtoRegister dtoRegister) {
		try {
			return new ResponseEntity<ResponseDto>(
					new ResponseDto(true, "updated successfully", service.update(dtoRegister)), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody EmpDto dto) {
		try {
			return new ResponseEntity<ResponseDto>(new ResponseDto(true, "login succesful", service.login(dto)),
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("wrong Id or pswd", HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(EmpDtoDelete dto) {
		try {
			return new ResponseEntity<ResponseDto>(new ResponseDto(true, "deleted", service.delete(dto)),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("something went wrong!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		
		try {
			return new ResponseEntity<>(new ResponseDto(true, "found all data", service.getAll()),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(false, "No data", null), HttpStatus.BAD_REQUEST);
		}
	}
}
