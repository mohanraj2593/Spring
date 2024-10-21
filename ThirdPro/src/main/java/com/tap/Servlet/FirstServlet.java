package com.tap.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException{
System.out.println("Hello First Servlet");
	}
}
