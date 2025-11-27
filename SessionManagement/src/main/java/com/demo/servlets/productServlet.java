package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.MyUser;
import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet("/showproduct")
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		MyUser user= (MyUser) session.getAttribute("user");
		//if(user!=null &&user.getRole().equals("user")) {
		String btn = request.getParameter("btn");
		if(user!=null && user.getRole().equals("user") && btn != null) {
			//String btn = request.getParameter("btn");
			switch(btn){
				case "show" ->{
					String name= request.getParameter("category");
					ProductService pservice=new ProductServiceImpl();
					String cleanName = name != null ? name.trim() : "";
					List<Product> plist = pservice.getByName(cleanName);
					out.println("<form action = 'AddToCart'>");
					for(Product p:plist) {
						out.println("<input type='checkbox' name='pname' id='"+p.getPid()+ "'value='"+p.getPname()+"'><label for='"+p.getPid()+"'>"+p.getPname()+"</label>" );
					}
					out.println("<button type='submit' name='btn' value='add' id='addToCartBtn'>Add To cart</button>");
				//out.println("<button type='submit' name= 'btn' id='btn'>Add To cart</button>");
					out.println("</form>");
					out.println("<a href='logout'>Logout</a>");
				}
				
				case "order" ->{
					RequestDispatcher rd = request.getRequestDispatcher("placeOrder");
					rd.forward(request, response);
				}
			}
		}
		else {
			out.println("<h1>Unautherize access</h1>");
			
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}
		
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
