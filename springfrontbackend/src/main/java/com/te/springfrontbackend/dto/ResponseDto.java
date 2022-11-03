package com.te.springfrontbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDto {

	private String msg;
	private boolean status;
	private Object obj;
	
}
