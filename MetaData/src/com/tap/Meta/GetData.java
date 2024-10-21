package com.tap.Meta;

import java.sql.*;

public class GetData {
	static Connection con;
	static Statement stmt;
	static ResultSet result;
	static ResultSetMetaData rsmd;

	public static void main(String[] args) {
		String sql="select * from student";
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Model","root","mohanraj@123");
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			rsmd = result.getMetaData();
			int count =rsmd.getColumnCount();
			for(int i=1;i<=count;i++) {
				System.out.println(rsmd.getColumnName(i)+" "+rsmd.getColumnTypeName(i));
				
			}
			
		
			
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		}

}
