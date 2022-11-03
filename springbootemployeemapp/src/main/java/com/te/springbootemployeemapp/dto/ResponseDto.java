package com.te.springbootemployeemapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDto {

	private boolean status;
	private String msg;
	private Object obj;
	
}
