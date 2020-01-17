package com.zensar.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.bean.Employee;
import com.zensar.dao.EmployeeDao;  

@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String empId=request.getParameter("employeeId");  
        int id=Integer.parseInt(empId);  
        String empName=request.getParameter("employeeName");  
        String profile=request.getParameter("profile");  
 ;  
          
        Employee employee = new Employee();  
        employee.setEmployeeId(id);  
        employee.setEmployeeName(empName);  
        employee.setProfile(profile);   
          
        int status = 0 ;
		try {
			status = EmployeeDao.updateEmployee(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  