package com.te.employeemanagementsystem.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {

	public static final String ACCOUNT_SID = "AC7158f13e41a6a81fee3308ae2d7125b6";
	public static final String AUTH_TOKEN = "36ceb8c8b64a9b2b5e9703a3da648808";

	public static void messageSender(String number) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message message = Message.creator(new PhoneNumber(number), new PhoneNumber("+15627845091"),
				"Welcome Your Registration Done Succesully").create();

		System.out.println(message.getAccountSid());
	}
}
