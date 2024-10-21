package com.tap.jdbc;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
public class MyConnection {
	static String url="jdbc:mysql://localhost:3306/Model";
	static String username="root";
	static String password="mohanraj@123";
	static Connection con;
	public static Connection connect() {
		try {
//			1.Load The Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//			2.Establish the Connection between Database
		con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			e.printStackTrace();
			}
		return con;
}
	static public void closeConnection(ResultSet result,Statement stmt,Connection con) {
		try {
			if(result!=null) {
				result.close();
				System.out.println("ResultSet is Closed");
				}
			if(stmt!=null) {
				stmt.close();
				System.out.println("Statement is Closed");
				}
			if(con!=null) {
			con.close();
			System.out.println("Connection is Closed");
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
