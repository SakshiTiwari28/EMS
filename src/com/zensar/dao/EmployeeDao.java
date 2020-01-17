package com.zensar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zensar.bean.Employee;

public class EmployeeDao {
	
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/employee";
		String userName = "root";
		String password = "root";

		Class.forName(driverName);
		con = DriverManager.getConnection(url, userName, password);
		
		
		return con;
	}
	
	public int addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
		
		Connection con = createConnection();
		String sql = "insert into employee values (?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, employee.getEmployeeId());
		pst.setString(2, employee.getEmployeeName());
		pst.setString(3, employee.getProfile());

		int result = pst.executeUpdate();

		return result;
	}
	

	public static List<Employee> getAllEmployees() throws Exception {
		List<Employee> listOfAllEmployees = new ArrayList<Employee>();
		Connection con = createConnection();
		String sql = "select * from employee";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			int employeeId = rs.getInt("employeeId");
			String employeeName = rs.getString("employeeName");
			String profile = rs.getString("profile");
			Employee employee = new Employee( employeeId, employeeName, profile);
			listOfAllEmployees.add(employee);
		}
		return listOfAllEmployees;
    }

	

	public static Employee getEmployee(int employeeId) throws Exception {
		Employee employee = null;
		Connection con = createConnection();
		String sql = "select * from employee where employeeId=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, employeeId);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			employeeId = rs.getInt("employeeId");
			String employeeName = rs.getString("employeeName");
			String profile = rs.getString("profile");
			employee = new Employee(employeeId, employeeName, profile);

		}
		return employee;

	}

	public static int deleteEmployee(int employeeId) throws Exception {

		Connection con = createConnection();
		String sql = "delete from employee where employeeId=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, employeeId);
		int result = pst.executeUpdate();

		return result;

	}

	public static int updateEmployee(Employee employee) throws Exception {

		Connection con = createConnection();
		// update the new value into the employee table
		String sql = "update employee set employeeName=?, profile=? where employeeId=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, employee.getEmployeeName());
		pst.setString(2, employee.getProfile());
		pst.setInt(3, employee.getEmployeeId());
		int result = pst.executeUpdate();

		return result;
		
		
	}
	
	
}
