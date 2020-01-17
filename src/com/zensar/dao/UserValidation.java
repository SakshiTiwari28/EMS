package com.zensar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zensar.bean.User;
import com.zensar.util.DBConnection;

public class UserValidation {
	
	public static boolean validate(User user) throws SQLException {
		
		    boolean status = false;
	        Connection conn = null;
	        PreparedStatement pst = null;
	        ResultSet rs = null;
	        
	        try {
				   conn = DBConnection.getConnection();
				   pst = conn.prepareStatement("select * from login where userName = ? AND password = ?");
			        pst.setString(1,user.getUserName());
			        pst.setString(2,user.getPassword());
			        rs = pst.executeQuery();
			        status = rs.next();
			        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception thrown" +e);
			}
	        
	        finally {
	      
	        	rs.close();
	        	pst.close();
	        	conn.close();
	        }
	        
	        return status;
	     
	        
	    }

}
