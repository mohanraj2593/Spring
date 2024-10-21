package com.tap.register;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.IOException;
import java.sql.*;

@WebServlet("/insertEmployee")
public class InsertEmployee extends HttpServlet {
	String INSERT="insert into employee(empid,empname,desig,salary) values(?,?,?,?)";
	private Connection con;
	private PreparedStatement pstmt;
	@Override
	public void init() throws ServletException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sepjee","root","mohanraj@123");
			 pstmt=con.prepareStatement(INSERT);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
			
			int empid=	Integer.parseInt(req.getParameter("empid"));	
			String empname=req.getParameter("empname");
			String empdesig=req.getParameter("empdesig");
			int empsal=Integer.parseInt(req.getParameter("empsal"));
			res.getWriter().println(empid+" "+empname+" "+empdesig+" "+empsal);
			
			try {
				
				pstmt.setInt(1, empid);
				pstmt.setString(2, empname);
				pstmt.setString(3,empdesig);
				pstmt.setInt(4, empsal);
				int x=pstmt.executeUpdate();
				if(x==0) {
					res.sendRedirect("Failure.html");
				}
				else {
					res.sendRedirect("Success.html");
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
					}
}
