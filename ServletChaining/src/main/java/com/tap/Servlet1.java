package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	PrintWriter pw;
	 RequestDispatcher rd;
protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException {
	try {
		 pw = res.getWriter();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String name =req.getParameter("username");
	String email=req.getParameter("email");
	String mobileno=req.getParameter("mobile");
	
	pw.println("Welcome to first Servlet "+name+" "+email+" "+mobileno);
	 try {
//			res.sendRedirect("SServlet");
			 rd = req.getRequestDispatcher("SServlet");
			 rd.include(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
