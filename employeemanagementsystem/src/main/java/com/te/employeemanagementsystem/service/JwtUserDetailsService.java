package com.te.employeemanagementsystem.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.employeemanagementsystem.dao.EmpDAO;
import com.te.employeemanagementsystem.entity.Employee;

@Service
public class JwtUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private EmpDAO dao;

//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//		// fetching user from database
//		Employee employee= dao.findByEmail(email);
//		if (!employee.equals(null)) {
//
//			return new User(employee.getEmail(), employee.getPassword(), new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found");
//		}
//	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Employee user = dao.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new User(user.getEmail(), user.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority("ROLE_"+user.getRole())));
	}
	
//	public Employee save(Employee emp) {
//		Employee employee = new Employee();
//		employee.setEmail(emp.getEmail());
//		employee.setPassword(bcryptEncoder.encode(emp.getPassword()));
//		return dao.save(employee);
//	}



	
}