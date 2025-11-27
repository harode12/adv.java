package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.MyUser;


@WebServlet("/placeOrder")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MyUser user= (MyUser) session.getAttribute("user");
		PrintWriter out = response.getWriter();
		if(user!= null && user.getRole().equals("user")) {
			
		List<String> cart= (List<String>) session.getAttribute("cart");	
		//ADDED NEW
		 if (cart == null || cart.isEmpty()) {
             out.println("<h1>Order Not Placed</h1>");
             out.println("<p style='color: red;'>Your cart is empty. Please select products first.</p>");
             out.println("<a href='category'>Back to Categories</a>");
         } else {
             // Now it's safe to use stream()
             out.println("<h1>Order Summary</h1>");
             out.println("<ul>");
             cart.stream().forEach(s -> out.println("<li>" + s + "</li>"));
             out.println("</ul>");
             
             out.println("<h4>Your order is placed successfully!</h4>");
         }
		////////////
		//cart.stream().forEach(s->out.println(s));
		//out.println("<h4> your order is placed successfully</h4>");
		out.println("<a href='logout'>Logout</a>");
		}
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
