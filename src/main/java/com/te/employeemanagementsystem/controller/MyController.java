package com.te.employeemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.te.employeemanagementsystem.entity.Employee;
import com.te.employeemanagementsystem.service.EmployeeService;

import lombok.Data;

@Controller
public class MyController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/register")
	public String registrationForm() {
		return "registrationform";
	}

	@GetMapping("/login")
	public String loginForm() {
		return "loginform";
	}

	@PostMapping("/registerbutton")
	public String registerData(ModelMap map, Employee employee) {
		if (employee != null) {
			if (employeeService.register(employee)) {
				map.addAttribute("msg", "Registration successful");
			} else {
				map.addAttribute("errMsg", "Something went wrong");
			}
		}
		return "registrationform";
	}
}
