package com.tap.jdbc;
import java.sql.*;
import java.util.Scanner;

public class First {

	public static void main(String[] args) {
		String sql="select*from student";
		try {
		
		
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Model","root","mohanraj@123");
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			while(result.next()) {
				for(int i=1;i<=4;i++) 
				{
					System.out.print(result.getString(i)+" ");
				
					
				}
				System.out.println();
				
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}
