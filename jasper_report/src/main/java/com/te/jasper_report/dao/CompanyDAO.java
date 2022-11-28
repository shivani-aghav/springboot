package com.te.jasper_report.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.jasper_report.entity.CompanyDetails;

public interface CompanyDAO extends CrudRepository<CompanyDetails, Integer>{

	CompanyDetails findByCompanyDetailss(String companyDetails);
}
