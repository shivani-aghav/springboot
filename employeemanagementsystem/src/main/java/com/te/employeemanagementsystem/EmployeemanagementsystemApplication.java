package com.te.employeemanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.jsonwebtoken.io.IOException;

@SpringBootApplication
public class EmployeemanagementsystemApplication {

	public static void main(String[] args) throws IOException, java.io.IOException {
		SpringApplication.run(EmployeemanagementsystemApplication.class, args);

//		String apiKey = "M4ijzfs6lbkaF7IP13oYTKJeDXOgmRVZC0yQdnLupNEqAxt28cbOlyFpWRQB6ndwACLvH1UIks5aitmP";
//		String sendId = "FSTSMS";
//		String message = "HI YOUR OTP IS 1111";
//		String language = "english";
//		String route = "v3";
//		message = URLEncoder.encode(message, "UTF-8");
//		String number = "9325435362";
//		String myUrl = "https://www.fast2sms.com/dev/bulkV2?authorization=" + apiKey + "&message=" + message
//				+ "&language=" + language + "&route=" + route + "&numbers=" + number;
//		System.out.println(myUrl);
//		URL url = new URL(myUrl);
//		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
//		con.setRequestMethod("GET");
//		con.setRequestProperty("User-Agent", "Mozilla/5.0");
//		con.setRequestProperty("cache-control", "no-cache");
//		int responseCode = con.getResponseCode();
//		StringBuilder response = new StringBuilder();
//		System.err.println(message + "     hello");
//		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//
//		System.out.println("Wait..............");
//
//		int code = con.getResponseCode();
//		System.out.println("Response code : " + code);
//
//		while (true) {
//			String line = br.readLine();
//			if (line == null) {
//				break;
//			}
//			response.append(line);
//		}
//		System.out.println(response);
//	}

	// Find your Account Sid and Token at twilio.com/user/account
	}
}
