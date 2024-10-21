package com.ops;

import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class OpsFile
 */
//@WebServlet("/OpsFile")
public class OpsFile extends jakarta.servlet.http.HttpServlet {
	int x;
	int y;
	 PrintWriter pw;
	 HttpSession session;
	
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException {
		x=Integer.parseInt(req.getParameter("x"));
		y=Integer.parseInt(req.getParameter("y"));
		
  try {
	  
      int sum=add(x,y);
     int diff=sub(x,y);
     int pro=mul(x,y);
     int quo=div(x,y);
     session=req.getSession();
     session.setAttribute("sum",sum);
     session.setAttribute("diff", diff);
     session.setAttribute("pro", pro);
     session.setAttribute("quo", quo);
     
     res.sendRedirect("first.jsp");
	}
  catch(Exception e) {
	  e.printStackTrace();
  }
  }
  
	
	int add(int a,int b) {
		return a+b;
	}
	int sub(int a,int b) {
		return a-b;
	}
	int mul(int a,int b) {
		return a*b;
	}
	int div(int a,int b) {
		return a/b;
	}
}
