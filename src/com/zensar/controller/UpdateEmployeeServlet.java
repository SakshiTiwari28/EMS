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


@WebServlet("/EditEmployee")  
public class UpdateEmployeeServlet extends HttpServlet {
	
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    	
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Employee</h1>");  
        String empId=request.getParameter("employeeId");  
        int id=Integer.parseInt(empId);  
          
        Employee employee = null;
		try {
			employee = EmployeeDao.getEmployee(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
          
        out.print("<form action='EditServlet' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='employeeId' value='"+employee.getEmployeeId()+"'/></td></tr>");  
        out.print("<tr><td>Employee Name:</td><td><input type='text' name='employeeName' value='"+employee.getEmployeeName()+"'/></td></tr>");  
        out.print("<tr><td>Profile:</td><td><input type='text' name='profile' value='"+employee.getProfile()+"'/></td></tr>");  
      
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  
