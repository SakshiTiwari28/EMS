package com.zensar;

import java.util.List;

import com.zensar.bean.Employee;
import com.zensar.dao.EmployeeDao;

public class Test {
public static void main(String[] args) throws Exception {
	
	EmployeeDao employeeDao = new EmployeeDao();
//	Employee employee = new Employee(1002, "David", 50000);
//	int result = employeeDao.addEmployee(employee);
	
	List<Employee> listOfAllEmployees = employeeDao.getAllEmployees();
	for(Employee employee1:listOfAllEmployees) {
		System.out.println(employee1.getEmployeeId());
		System.out.println(employee1.getEmployeeName());
		System.out.println(employee1.getProfile());
	}
}
}
