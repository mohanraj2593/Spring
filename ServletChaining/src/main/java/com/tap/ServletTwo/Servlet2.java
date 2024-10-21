package com.tap.ServletTwo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
	PrintWriter pw;
protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException {
	 try {
		pw = res.getWriter();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 String name =req.getParameter("username");
	 String email = req.getParameter("email");
	 String mobileno = req.getParameter("mobile");
	 pw.println("Welcom to Second servlet "+name+" "+email+" "+mobileno);
}
}
