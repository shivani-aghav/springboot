package com.te.jasper_employeemangementsystem.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.jasper_employeemangementsystem.entity.CompanyDetails;

public interface CompanyDAO extends CrudRepository<CompanyDetails, Integer>{

	CompanyDetails findByCompanyDetailss(String companyDetails);
}
