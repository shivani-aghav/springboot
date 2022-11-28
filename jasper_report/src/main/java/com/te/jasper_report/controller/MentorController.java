package com.te.jasper_report.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.jasper_report.dto.ResponseDTO;
import com.te.jasper_report.service.EmployeeService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@RestController
@RequestMapping("/mentor")
public class MentorController {

	@Autowired
	private EmployeeService service;
 
	@Autowired
	private DataSource dataSource;


	@GetMapping("/getAll")
	public ResponseEntity<ResponseDTO> getAll() throws FileNotFoundException, JRException, SQLException{
		String filePath = "D:\\TECHNO ELEVATE\\SpringBoot\\jasper_employeemangementsystem\\src\\main\\resources\\jasper.jrxml";
		File file = ResourceUtils.getFile(filePath);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		HashMap<String, Object> map = new HashMap<>();
		JasperPrint print = JasperFillManager.fillReport(jasperReport, map,dataSource.getConnection());
		JasperExportManager.exportReportToPdfFile(print, "D:\\TECHNO ELEVATE\\Jasper\\jasperOne.pdf");
		return new ResponseEntity<>(new ResponseDTO(false, "Data Found", ""), HttpStatus.OK);

	}
	@GetMapping("/getAddress")
	public ResponseEntity<ResponseDTO> getAllAddress() throws FileNotFoundException, JRException, SQLException{
		String filePath = "D:\\TECHNO ELEVATE\\SpringBoot\\jasper_employeemangementsystem\\src\\main\\resources\\jasper2.jrxml";
		File file = ResourceUtils.getFile(filePath);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		HashMap<String, Object> map = new HashMap<>();
		JasperPrint print = JasperFillManager.fillReport(jasperReport, map,dataSource.getConnection());
		JasperExportManager.exportReportToPdfFile(print, "D:\\TECHNO ELEVATE\\Jasper\\jasperTwo.pdf");
		return new ResponseEntity<>(new ResponseDTO(false, "Addresses Found", ""), HttpStatus.OK);
	}
	
	@PostMapping("/getById/{employeeId}")
	public ResponseEntity<ResponseDTO> getById(@PathVariable String employeeId) throws FileNotFoundException, JRException, SQLException{
		String filePath = "D:\\TECHNO ELEVATE\\SpringBoot\\jasper_employeemangementsystem\\src\\main\\resources\\jasperById.jrxml";
		File file = ResourceUtils.getFile(filePath);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		HashMap<String, Object> map = new HashMap<>();
		map.put("employeeId", employeeId);
		JasperPrint print = JasperFillManager.fillReport(jasperReport, map,dataSource.getConnection());
		JasperExportManager.exportReportToPdfFile(print, "D:\\TECHNO ELEVATE\\Jasper\\GetEmployeeById.pdf");
		return new ResponseEntity<>(new ResponseDTO(false, "Data Found", null), HttpStatus.OK);
	}
	
	@PostMapping("/getbycompany/{employeeId}")
	public ResponseEntity<ResponseDTO> getCompanyDetails(@PathVariable String employeeId) throws FileNotFoundException, JRException, SQLException{
		String filePath = "D:\\TECHNO ELEVATE\\SpringBoot\\jasper_employeemangementsystem\\src\\main\\resources\\jasper4.jrxml";
		File file = ResourceUtils.getFile(filePath);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		HashMap<String, Object> map = new HashMap<>();
		map.put("employeeId", employeeId);
		JasperPrint print = JasperFillManager.fillReport(jasperReport, map,dataSource.getConnection());
		JasperExportManager.exportReportToPdfFile(print, "D:\\TECHNO ELEVATE\\Jasper\\CompanyDetailsOfEmployee.pdf");
		return new ResponseEntity<>(new ResponseDTO(false, "Data Found", null), HttpStatus.OK);
	}
	@PostMapping("/getcrosstab/{companyId}")
	public ResponseEntity<ResponseDTO> getCrossTab(@PathVariable Integer companyId) throws FileNotFoundException, JRException, SQLException{
		String filePath = "D:\\TECHNO ELEVATE\\SpringBoot\\jasper_employeemangementsystem\\src\\main\\resources\\crossTab.jrxml";
		File file = ResourceUtils.getFile(filePath);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		HashMap<String, Object> map = new HashMap<>();
		map.put("companyId", companyId);
		JasperPrint print = JasperFillManager.fillReport(jasperReport, map,dataSource.getConnection());
		JasperExportManager.exportReportToPdfFile(print, "D:\\TECHNO ELEVATE\\Jasper\\CrossTab.pdf");
		return new ResponseEntity<>(new ResponseDTO(false, "Data Found", null), HttpStatus.OK);
	}
	
	@PostMapping("/getcrosstabtask6/{companyId}")
	public ResponseEntity<ResponseDTO> getCrossTabTask6(@PathVariable Integer companyId) throws FileNotFoundException, JRException, SQLException{
		String filePath = "D:\\TECHNO ELEVATE\\SpringBoot\\jasper_employeemangementsystem\\src\\main\\resources\\crossTabTask6.jrxml";
		File file = ResourceUtils.getFile(filePath);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		HashMap<String, Object> map = new HashMap<>();
		map.put("companyId", companyId);
		JasperPrint print = JasperFillManager.fillReport(jasperReport, map,dataSource.getConnection());
		JasperExportManager.exportReportToPdfFile(print, "D:\\TECHNO ELEVATE\\Jasper\\CrossTabTask6.pdf");
		return new ResponseEntity<>(new ResponseDTO(false, "Data Found", null), HttpStatus.OK);
	}
}
