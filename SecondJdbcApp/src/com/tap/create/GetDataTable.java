package com.tap.create;
import java.sql.*;

public class GetDataTable {
	static Connection con;
     static  Statement stmt;
     static ResultSet result;
	static String SQL="select * from student";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Model","root","mohanraj@123");
			 stmt=con.createStatement();
			 result=stmt.executeQuery(SQL);
			 while(result.next()) {
				 System.out.println(result.getString(1)+"   "
						 +result.getInt(2)+"   "
						 +result.getString(3)+"   "
						 +result.getInt(4));
			 }			 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
