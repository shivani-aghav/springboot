package com.te.employeemanagementsystem.helper;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.te.employeemanagementsystem.dto.ResponseDTO;
import com.te.employeemanagementsystem.exception.EmployeeNotFoundException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = -7858869558953243875L;

	@Autowired
	private ResponseDTO dto;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {

//		dto.msg();
		
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorizedd");
		throw new EmployeeNotFoundException("Unauthorized user !!");
		
	}
	
}
