package com.tap.acad;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tap.acad.model.employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
public class fetchAll extends HttpServlet{
	private ArrayList<employee> empList = new ArrayList<employee>();
	PrintWriter pw;
	private Connection con;
	Statement stmt;
	ResultSet result;
	HttpSession session;
	private String fetchAll="select * from employee";
	@Override
		public void init() throws ServletException {
			try {
				Class.forName("com.mysql.cj.Driver");
				 con=DriverManager.getConnection("jdbc:mysql:localhost://3306/sepjee/eemployee");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
try {
	
	
	
	stmt=con.createStatement();
	 result=stmt.executeQuery(fetchAll);
	 while(result.next()) {
//		 @SuppressWarnings({"rawtype","unused","serial"})
		 empList.add(new employee(result.getInt("empid"),
			 		result.getString("empname"),
			 				result.getString("desig"),
			 				result.getInt("salary"),
			 				result.getString("email"),
			 				result.getString("password")));
					 
	 }
	 session=req.getSession();
	 session.setAttribute("empList", empList);
	 resp.sendRedirect("showEmployee.jsp");
	 
	 
	 
	 while(result.next()) {
//		 pw.println(result.getInt("empid")+" "
//		 		+ result.getString("empname")+" "
//		 				+result.getString("desig") +" "
//		 				+ result.getInt("salary")+" "
//		 				+result.getString("email")+" "
//		 				+result.getString("password")
//				 );
	 }
}
catch(Exception e) {
	e.printStackTrace();
}
}
}
