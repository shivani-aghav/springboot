package com.te.employeemanagementsystem.email;

public class EmailMessage {
	
		public static String getMess(String empName,String emailId,String password) {
			
			String mss="\r\n"
					+ "Hello "+empName+",\r\n"
					+ "\r\n"
					+ "Thank you for joining TestYantra your Email ID is "+emailId+".\r\n"
					+ "and password is "+password+".\r\n"
					+ "\r\n"
					+ "We’d like to confirm that your account was created successfully.\r\n"
			        + "\r\n"
			        + "You can login with Employee ID and your password.,\r\n"
			;
			return mss;
			
		}
		public static void main(String[] args) {
			
		}

	}

