package com.tap.Servlet1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


public class FirstServlet1 extends HttpServlet{
	PrintWriter pw;
protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException {
	 try {
		pw=res.getWriter();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 pw.println("<html><body>");
	 pw.println("<center>This is First Servlet1 Page</center>");
	 pw.println("</boy></html>");
	
}
}
