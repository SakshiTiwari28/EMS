package com.zensar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.bean.Employee;
import com.zensar.dao.EmployeeDao; 

@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='addEmployee.html'>Add New Employee</a>");  
        out.println("<h1>Zensar Employees List</h1>");  
          
        List<Employee> list = null;
		try {
			list = EmployeeDao.getAllEmployees();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
          
        out.print("<table border='1' width='100%'");  
        out.print
        ("<tr><th>EmployeeId</th><th>EmployeeName</th><th>Profile</th></tr>");  
        for(Employee e:list){  
         out.print
         ("<tr><td>"+e.getEmployeeId()+"</td><td>"+e.getEmployeeName()+"</td><td>"+e.getProfile()+
        	"</td><td><a href='EditEmployee?employeeId="+e.getEmployeeId()+"'>Edit</a></td>  <td><a href='DeleteServlet?employeeId="+e.getEmployeeId()+"'>Delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  