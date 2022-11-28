//package com.te.employeemanagementsystem.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//
//import com.te.employeemanagementsystem.dto.RegisterEmployeeDTO;
//import com.te.employeemanagementsystem.dto.ResponseDTO;
//import com.te.employeemanagementsystem.exception.EmployeeNotFoundException;
//import com.te.employeemanagementsystem.sms.TwilioProperties;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
//
//@Component
//public class TwilioMessageService {
//
//	RegisterEmployeeDTO dto;
//
//	@Autowired
//	private TwilioProperties properties;
//
//	public ResponseEntity<ResponseDTO> sendMessage() {
//		try {
//			PhoneNumber to = new PhoneNumber(dto.getPhoneNumber());
//			PhoneNumber from = new PhoneNumber(properties.getPhone_number());
//			
//			String messages = "Hii " + dto.getEmpName() + "thank you for joining TestYantra. " + "your email Id "
//					+ dto.getEmail() + "and password is " + dto.getPassword()
//					+ " kindly login with given credentials. ";
//			
//			Message create = Message.creator(to, from, messages).create();
//			
//			return new ResponseEntity<ResponseDTO>(new ResponseDTO(true, "message sent successfully", create),
//					HttpStatus.OK);
//		} catch (Exception e) {
//			throw new EmployeeNotFoundException("unable to send message !!");
//		}
//	}
//}
