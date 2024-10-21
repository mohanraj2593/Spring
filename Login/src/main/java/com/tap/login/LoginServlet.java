package com.tap.login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	String empname,desig,pwd;
	int empid,salary;
	Connection con;
	PreparedStatement pstmt;
	ResultSet result;
	String VALIDATE="select * from employee where email=?" ;
	@Override
		public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sepjee","root","mohanraj@123");
			 pstmt = con.prepareStatement(VALIDATE);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	try { 
		String email=req.getParameter("email");
		String password =req.getParameter("password");
		pstmt.setString(1, email);
		 result=pstmt.executeQuery();
		 if(result.next()) {
			 String dbpwd=result.getString("password");
			 if(password.equals(dbpwd)) {
				 empid=result.getInt("empid");
				 empname=result.getString("empname");
				 desig=result.getString("desig");
				 salary=result.getInt("salary");
				 pwd=result.getString("password");
				 
				 
				 HttpSession session=req.getSession();
				 session.setAttribute("empid", empid);
				 session.setAttribute("empname", empname);
				 session.setAttribute("desig", desig);
				 session.setAttribute("email", email);
				 session.setAttribute("pwd", pwd);
      			 session.setAttribute("salary", salary);
//				System.out.println(empid+" "+empname+" "+desig+" "+salary+" "+email+" "+pwd);
				
//				 res.sendRedirect("valid.html");
//				 res.sendRedirect("displayServlet");
				 RequestDispatcher rd=req.getRequestDispatcher("displayServlet");
				 rd.forward(req, res);
			 }
			 else {
				 res.sendRedirect("invalid.html");
			 }
		 }
		 else {
			 res.sendRedirect("Register.html");
		 }
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
}


