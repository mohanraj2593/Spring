package com.tap.controller;

import java.io.IOException;

import com.tap.daoimpl.UserDaoImpl;
import com.tap.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends jakarta.servlet.http.HttpServlet {
	
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String uname = req.getParameter("uname");
	String uemail = req.getParameter("uemail");
	String password=req.getParameter("passwor");
	String cpassword = req.getParameter("cpasswor");
	if(password.equals(cpassword)) {
		User user = new User(uname,uemail,password);
		UserDaoImpl udaoi = new UserDaoImpl();
		udaoi.register(user);
		resp.sendRedirect("Success.jsp");
		
	}
	else {
		resp.sendRedirect("failure.jsp");
	}
	
	
}
}
