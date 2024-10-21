package com.tap.Meta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class SetData {
	static Connection con;
	static PreparedStatement pstmt;
	static ResultSet result;
	static ResultSetMetaData rsmd;

	public static void main(String[] args) {
		String sql="insert into student(name,mark,department,student_id) values(?,?,?,?)";
		int sum=0;
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Model","root","mohanraj@123");
			pstmt = con.prepareStatement(sql);
			Scanner sc1 = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);
			for(int i=1;i<=2;i++) {
			
			System.out.println("Enter The student Name");
			String name = sc1.nextLine();
			System.out.println("Enter The student Mark");
			int mark = sc2.nextInt();
			System.out.println("Enter The student department");
			String department = sc1.nextLine();
			System.out.println("Enter the student stuent_id");
			int student_id = sc2.nextInt();
			
			
			
			
		
			pstmt.setString(1,name);
			pstmt.setInt(2,mark);
			pstmt.setString(3,department);
			pstmt.setInt(4,student_id);
			
			pstmt.addBatch();
//			int x = pstmt.executeUpdate();
//			System.out.println((sum+x)+"rows are updated");
			
//			System.out.println((sum+x)+"rows are updated");
			System.out.println(i+" query executed");
			}
		
			
			pstmt.executeBatch();
			System.out.println("Batch Executed Successfully");
			
			
		
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		
	}

}
