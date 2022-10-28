package com.te.springbootemployee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springbootemployee.dao.EmpDao;
import com.te.springbootemployee.entity.EmployeePrimaryInfo;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDao dao;

	@Override
	public EmployeePrimaryInfo register(EmployeePrimaryInfo primaryInfo) {
		return dao.save(primaryInfo);
	}

}
