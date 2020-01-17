package com.zensar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	/*
	 * public static void main(String args[]) throws SQLException { DBConnection obj
	 * = new DBConnection(); System.out.println(obj.getConnection()); }
	 */
	
	public static Connection getConnection() throws SQLException {
		
		Connection conn = null;
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/employee";
		String username = "root";
		String password = "root";
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url,username,password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection not Established..");
		}
		
		finally{
			
		}
		
		return conn;
	}

}
