package com.zensar.controller;
	
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zensar.bean.User;
import com.zensar.dao.UserValidation;

	@WebServlet("/login")
	public class LoginServlet extends HttpServlet { 
		
	    public void doPost(HttpServletRequest request, HttpServletResponse response)  
	                    throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        request.getRequestDispatcher("link.html").include(request, response);  
	          
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	        User user = new User();
	        user.setUserName(name);
	        user.setPassword(password);
	        

	      
	        
	        try {
				if(UserValidation.validate(user)) {
				
				  System.out.println("Hey there");
				  HttpSession session = request.getSession(false);
				  if(session!=null)
				  session.setAttribute("name",user.getUserName());
			  
				  RequestDispatcher rd=request.getRequestDispatcher("employee.html");  
				  rd.forward(request,response); 
				  out.print("<p> Welcome </p>" + user.getUserName());
				}
				else {
					System.out.println("Invalid ");
					out.print("Invalid Credentials");
					response.sendRedirect("login.html");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        out.close();
	        
	          
	    }  
	    
	  
		
}  


