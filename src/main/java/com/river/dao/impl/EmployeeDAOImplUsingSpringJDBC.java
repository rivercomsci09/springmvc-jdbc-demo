package com.river.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.river.dao.EmployeeDAO;
import com.river.domain.Employee;


public class EmployeeDAOImplUsingSpringJDBC implements EmployeeDAO{
	
	JdbcTemplate jdbcTemplate;
	
	//SpringJdbcTemplate inserted using constructor injection.
	public EmployeeDAOImplUsingSpringJDBC(JdbcTemplate jdbcTemplate) {
        try {
            this.jdbcTemplate = jdbcTemplate;
            Class.forName("org.hsqldb.jdbcDriver");
            createEmployeeTable();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Exception occured in DAO constructor");
        }
    }
	
	private void createEmployeeTable() {
        try {
            jdbcTemplate.update("create table Employee(empId VARCHAR(20), name VARCHAR(50), designation VARCHAR(50),salary VARCHAR(50))");
        }
        catch (Exception e) {
            System.out.println("Employee table has already been created...");
        }
    }
	
	public void addNewEmployee(Employee employee) {
        jdbcTemplate.update("insert into Employee (empid, name, designation) values (?, ?, ?)",
            employee.getEmpId(), employee.getName(), employee.getDesignation());
    }
	
	public List getAllEmployees() {
        return jdbcTemplate.query("select * from Employee", new EmployeeMapper());
    }
}

//implement Spring RowMapper.
class EmployeeMapper implements RowMapper {

  public Employee mapRow(ResultSet rs, int rowNumber) throws SQLException {
      String empId = rs.getString(1);
      String name = rs.getString(2);
      String designation = rs.getString(3);
      double salary = 0;
      Employee emp = new Employee(empId, name, designation, salary);
      return emp;
  }

}
