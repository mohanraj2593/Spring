package com.tap.acad;

import jakarta.servlet.ServletException;

//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;

/**
 * Servlet implementation class addEmployee
 */
//@WebServlet("/addEmployee")
public class addEmployee extends HttpServlet {
	String INSERT="insert into employee(empname,desig,salary,email,password) values(?,?,?,?,?)";
	Connection con;
@Override
public void init() throws ServletException {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sepjee","root","mohanraj@123");
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}
@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			PreparedStatement pstmt = con.prepareStatement(INSERT);
			pstmt.setString(1,req.getParameter("empname"));
			pstmt.setString(2,req.getParameter("desig"));
			pstmt.setInt(3,Integer.parseInt(req.getParameter("salary")));
			pstmt.setString(4, req.getParameter("email"));
			pstmt.setString(5, req.getParameter("password"));
			int x=pstmt.executeUpdate();
			if(x!=0) {
				res.sendRedirect("fetchAll");
			}
			else {
				res.sendRedirect("failure.jsp	");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
