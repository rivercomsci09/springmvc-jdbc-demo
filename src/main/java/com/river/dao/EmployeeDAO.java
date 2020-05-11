package com.river.dao;

import java.util.List;

import com.river.domain.Employee;

public interface EmployeeDAO {

	public void addNewEmployee(Employee employee);

	public List<Employee> getAllEmployees();
}
