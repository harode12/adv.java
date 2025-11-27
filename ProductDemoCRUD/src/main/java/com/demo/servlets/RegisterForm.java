package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.RegisterService;
import com.demo.service.RegisterServiceImpl;


@WebServlet("/newuser")
public class RegisterForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		String uname= request.getParameter("uname");
		String pass=request.getParameter("pass");
		String email= request.getParameter("email");
		String role= request.getParameter("role");
		String gender=request.getParameter("gender");
		RegisterService rservice = new RegisterServiceImpl();
		boolean status=rservice.registerUser(uname,pass,email,gender);
		if(status) {
			RequestDispatcher rs=request.getRequestDispatcher("login.html");
			rs.forward(request, response);
		}
		else {
			out.print("Unable to Register");
		}
	}

}
