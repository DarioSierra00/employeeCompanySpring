package com.jacaranda.employeeCompany.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EmployeeProject {

	@Id
	@ManyToOne
	@JoinColumn(name="idProject")
	private Project project;
	
	@Id
	@ManyToOne
	@JoinColumn(name="idEmployee")
	private Employee employee;
	
	private int minutes;
}
