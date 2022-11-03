package com.te.springbootemployeemapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class EmpSkills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer skId;
	private String skill;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<EmployeePrimaryInfo> primaryInfo;
}
