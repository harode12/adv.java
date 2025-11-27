package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/validateuser")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out  =response.getWriter();
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		LoginService lservice= new LoginServiceImpl();
		MyUser user=lservice.validateUser(uname,pass);
		
		if(user!=null) {
			HttpSession session = request.getSession();
			if(session.isNew()) {
				System.out.println("new session");
				session.setMaxInactiveInterval(20000);
			}
			session.setAttribute("user", user);
			RequestDispatcher rd =  request.getRequestDispatcher("category");
			rd.forward(request, response);
		}else {
			out.println("<h5>Invalid Credential</h5>"); 
			RequestDispatcher rd= request.getRequestDispatcher("login.html");
			rd.include(request, response);
			
		}
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
