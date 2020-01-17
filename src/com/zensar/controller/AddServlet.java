package com.zensar.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zensar.bean.Employee;
import com.zensar.dao.EmployeeDao;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet{
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) {
		
		String methodToCall = request.getParameter("methodToCall");
		if(methodToCall.equalsIgnoreCase("addEmployee")) {
			addEmployee(request,response);
		}
	}
		public void addEmployee(HttpServletRequest request, HttpServletResponse response) {
			int employeeId = Integer.parseInt(request.getParameter("employeeId"));
			String employeeName = request.getParameter("employeeName");
			String profile = request.getParameter("profile");
		
			System.out.println("employeeId:"+employeeId);
			System.out.println("employeeName:"+employeeName);
			System.out.println("profile:"+profile);
			
			EmployeeDao employeeDao = new EmployeeDao();
			try {
				int result = employeeDao.addEmployee(new Employee(employeeId, employeeName, profile));
				response.sendRedirect("success.html");
				
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Exception has occured");
			}
		}
		
		
	/*
	 * public void doPost(HttpServletRequest request, HttpServletResponse response)
	 * { doGet(request, response); }
	 */
		

}

