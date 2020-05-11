package com.river.service;

import java.util.List;

import com.river.dao.EmployeeDAO;
import com.river.domain.Employee;

public class EmployeeService {

	EmployeeDAO empDAO;

	public EmployeeService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeService(EmployeeDAO empDAO) {
		super();
		this.empDAO = empDAO;
	}
	
	public EmployeeDAO getEmpDAO() {
		return empDAO;
	}

	public void setEmpDAO(EmployeeDAO empDAO) {
		this.empDAO = empDAO;
	}

	public void addNewEmployee(Employee emp) {
		empDAO.addNewEmployee(emp);
	}

	public List<Employee> getEmployees() {
		return empDAO.getAllEmployees();
	}
}
