package com.tap.jdbc;

//import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class FirstJdbc {
	static Connection con;
	static Statement stmt;
	static ResultSet result;
	public static void main(String args[]) {
		try {
			con=MyConnection.connect();
			
//			3.create The SQL statement
		stmt=con.createStatement();	
			 System.out.println("Statement "+stmt);
//			 4.Execute SQL Statement
			 result=stmt.executeQuery("select* from student");
			 System.out.println("Result Set "+result);
//			 5.Process The Data
			 while(result.next()) {
				System.out.println(result.getString(1)+"   "
			+result.getInt(2)+"   "+
						result.getString(3));
				}
		} catch (SQLException e) {
			System.out.println("Class Not Found");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			MyConnection.closeConnection(result,stmt,con);
		}
		
	}
 
}
