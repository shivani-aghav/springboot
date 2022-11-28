package com.te.employeemanagementsystem.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.employeemanagementsystem.dao.EmpDAO;
import com.te.employeemanagementsystem.entity.Employee;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private EmpDAO dao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		// fetching user from database
		Employee employee= dao.findByEmail(email);
		if (!employee.equals(null)) {

			return new User(employee.getEmail(), employee.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found");
		}
	}
	
	public Employee save(Employee emp) {
		Employee employee = new Employee();
		employee.setEmail(emp.getEmail());
		employee.setPassword(bcryptEncoder.encode(emp.getPassword()));
		return dao.save(employee);
	}

//	private static Collection<? extends GrantedAuthority> getAuthorities(Employee employee){
//		String [] userRoles= employee.getRoles().stream().map((roles)->roles.getName()).toArray(String[]::new);
//		Collection<GrantedAuthority> authorities=AuthorityUtils.createAuthorityList(userRoles);
//		return authorities;
//	}
}
