package com.te.employeemanagementsystem.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class ResponseDTO {

	private boolean status;
	private String message;
	private Object data;
	
	public ResponseDTO msg() {
		return new ResponseDTO(false,"Unauthorized User",null);
		
	}
}
