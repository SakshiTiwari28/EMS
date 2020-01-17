package com.zensar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.dao.EmployeeDao;  

@WebServlet("/DeleteServlet")  
public class DeleteServlet extends HttpServlet {  
	
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    	
        String employeeId = request.getParameter("employeeId");  
        int id = Integer.parseInt(employeeId);  
        try {
			EmployeeDao.deleteEmployee(id);
			response.sendRedirect("ViewServlet"); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
         
        
    }  
}  