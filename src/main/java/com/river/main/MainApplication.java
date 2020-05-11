package com.river.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.river.domain.Employee;
import com.river.service.EmployeeService;

public class MainApplication {
	public static void main(String[] args) {

//		EmployeeDAO empDAO = new EmployeeDAO();

		// insert dependency using new keyword
//	    EmployeeDAO empDAO = new EmployeeDAO(); 
//	    EmployeeService empService = new EmployeeService();

		// insert dependency using setter
//		EmployeeService empService = new EmployeeService();
//		empService.setEmpDAO(empDAO);

		// insert dependency using Constructor injection
//		EmployeeService empService = new EmployeeService(empDAO);

		// Load the Spring container using the Spring Configuration File
//		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Retrieve the Bean from the Spring Conatiner
//		EmployeeService empService = container.getBean(EmployeeService.class);

		/***** Without using Dependency Injection is declare empDAO in class service by keyword "new". It will dependency between empDAO with empService.
		 */
		
		/***** Using Java core injection
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		EmployeeService empService = new EmployeeService();
		// insert dependency using setter
		empService.setEmpDAO(empDAO);
		// insert dependency using Constructor injection
		EmployeeService empService = new EmployeeService(empDAO);
		*/
		
		/***** Using spring
		 * Create applicationContext.xml
		 * Declare bean by setter or constructor
		 */
		// Load the Spring container using the Spring Configuration File
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve the Bean from the Spring Conatiner
		EmployeeService empService = container.getBean(EmployeeService.class);
		 
		Employee emp1 = new Employee("1", "Test1", "Manager", 1000);
		Employee emp2 = new Employee("1", "Test2", "Manager", 1000);
		Employee emp3 = new Employee("1", "Test3", "Manager", 1000);
		Employee emp4 = new Employee("1", "Test4", "Manager", 1000);
		Employee emp5 = new Employee("1", "Test5", "Manager", 1000);

		empService.addNewEmployee(emp1);
		empService.addNewEmployee(emp2);
		empService.addNewEmployee(emp3);
		empService.addNewEmployee(emp4);
		empService.addNewEmployee(emp5);

		List<Employee> employees = empService.getEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getName());
		}
	}
}
