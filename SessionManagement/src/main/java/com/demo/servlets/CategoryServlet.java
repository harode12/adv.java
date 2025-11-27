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
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;


@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session= request.getSession();
		MyUser user = (MyUser)session.getAttribute("user");
		if(user!=null && user.getRole().equals("user")) { 
        ProductService pservice= new ProductServiceImpl();
        List<String> carr=pservice.getAllCategory();
		out.println("<form action='showproduct'> <select name='category'>");
		for(String s: carr) {
			// out.println("<option value=' "+s+" ' >"+s+" </option>"); // Original
			out.println("<option value='"+s+"'>"+s+"</option>");
		}
		out.println("</select>");
//		out.println("<button type='submit' name='btn' id='btn' value ='show'>submit</button>");
//		out.println("<button type='submit' name='btn' id='btn' value ='order' >placeOrder</button>");
		out.println("<button type='submit' name='btn' id='subbtn' value ='show'>submit</button>");
		out.println("<button type='submit' name='btn' id='ordbtn' value ='order' >placeOrder</button>");
	
		////////////////////////////
		
		///////////////////////////////
		
		out.println("</form>");
		out.println("<a href='logout'>Logout</a>");
		}
		else {
			out.println("<h1>unauthrize access </h1>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


//package com.demo.servlets;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.demo.beans.MyUser;
//import com.demo.service.ProductService;
//import com.demo.service.ProductServiceImpl;
//
//@WebServlet("/category")
//public class CategoryServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        HttpSession session = request.getSession();
//        MyUser user = (MyUser) session.getAttribute("user");
//        if (user != null && user.getRole().equals("user")) {
//            ProductService pservice = new ProductServiceImpl();
//            List<String> carr = pservice.getAllCategory();
//            out.println("<form action='showproduct'> <select name='category'>");
//            for (String s : carr) {
//                out.println("<option value='" + s + "'>" + s + "</option>");
//            }
//            out.println("</select>");
//            out.println("<button type='submit' name='btn' id='subbtn' value='show'>submit</button>");
//            out.println("<button type='submit' name='btn' id='ordbtn' value='order'>placeOrder</button>");
//            out.println("</form>");
//
//            // NEW: Display cart contents if they exist
//            List<String> cart = (List<String>) session.getAttribute("cart");
//            if (cart != null && !cart.isEmpty()) {
//                out.println("<h3>Your Cart:</h3>");
//                out.println("<ul>");
//                for (String item : cart) {
//                    out.println("<li>" + item + "</li>");
//                }
//                out.println("</ul>");
//                out.println("<p>Total items: " + cart.size() + "</p>");
//            } else {
//                out.println("<p>Your cart is empty.</p>");
//            }
//
//            out.println("<a href='logout'>Logout</a>");
//        } else {
//            out.println("<h1>unauthorize access</h1>");
//            RequestDispatcher rd = request.getRequestDispatcher("login.html");
//            rd.include(request, response);
//        }
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//}

