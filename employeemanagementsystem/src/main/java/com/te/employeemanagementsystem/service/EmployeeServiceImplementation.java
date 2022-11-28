package com.te.employeemanagementsystem.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.employeemanagementsystem.dao.EmpDAO;
import com.te.employeemanagementsystem.dto.LoginDTO;
import com.te.employeemanagementsystem.dto.RegisterEmployeeDTO;
import com.te.employeemanagementsystem.dto.UpdateEmployeeDTO;
import com.te.employeemanagementsystem.email.EmailConfig;
import com.te.employeemanagementsystem.email.EmailMessage;
import com.te.employeemanagementsystem.entity.Employee;
import com.te.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.te.employeemanagementsystem.helper.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeServiceImplementation implements EmployeeService {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	private EmailConfig config;

//	@Autowired
//	private TwilioMessageService messageService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private EmpDAO dao;

	@Override
	public RegisterEmployeeDTO register(RegisterEmployeeDTO dtoRegister) {
		try {
			Employee employee = new Employee();
			BeanUtils.copyProperties(dtoRegister, employee);
			Employee save = dao.save(employee);
			log.info("data entered");

			BeanUtils.copyProperties(save, dtoRegister);
			
			config.sendMail(dtoRegister.getEmail(),
					EmailMessage.getMess(dtoRegister.getEmpName(), dtoRegister.getEmail(), dtoRegister.getPassword()));
			log.info("email sent");
			
//			SmsSender.messageSender(dtoRegister.getPhoneNumber());
			
			return dtoRegister;
		} catch (Exception e) {
			e.printStackTrace();
			log.warn("registration failed");
			throw new EmployeeNotFoundException("failed to register..!");
		}
	}

	@Override
	public List<Employee> getAll() {
		log.info("all data found");
		return (List<Employee>) dao.findAll();
	}

	@Override
	public UpdateEmployeeDTO update(UpdateEmployeeDTO update) {

		log.info("updating");
		Employee findById = dao.findByEmpId(update.getEmpId());

		if (findById == null) {
			throw new EmployeeNotFoundException("data not found ");
		}
		BeanUtils.copyProperties(update, findById);
		dao.save(findById);
		BeanUtils.copyProperties(findById, update);
		log.info("updated");
		return update;

	}

	@Override
	public void delete(Integer empId) {

		Employee findByEmpId = dao.findByEmpId(empId);
		if (findByEmpId == null) {
			throw new EmployeeNotFoundException("id not found ");
		}
		dao.deleteById(findByEmpId.getEmpId());
		log.info("deleted successfully");

	}

	@Override
	public Employee getById(Integer empId) {
//		Employee employee = dao.findById(empId).orElseThrow(() -> new EmployeeNotFoundException("id not found "));
		Employee findByEmpId = dao.findByEmpId(empId);
		if (findByEmpId != null) {
			log.info("data found byId");
			return findByEmpId;
		} else {
			throw new EmployeeNotFoundException("id not found ");
		}

	}

	public String login(LoginDTO login) {
		System.out.println(login);
		try {
			this.authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));

		} catch (UsernameNotFoundException e) {
			throw new EmployeeNotFoundException("Bad Crenditails");
		}
		String generateToken = "";
		try {
			UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(login.getEmail());
			generateToken = this.jwtUtil.generateToken(userDetails);
			System.out.println("JWT" + generateToken);
			Employee employee = dao.findByEmail(login.getEmail());
			employee.setToken(generateToken);
			dao.save(employee);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return generateToken;
	}
}
