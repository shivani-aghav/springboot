package com.te.jasper_report;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
@Slf4j
@SpringBootApplication
public class JasperReportApplication {

	public static void main(String[] args) throws JRException {
		SpringApplication.run(JasperReportApplication.class, args);
		
	}

}
