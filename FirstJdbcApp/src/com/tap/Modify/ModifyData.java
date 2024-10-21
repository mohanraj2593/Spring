package com.tap.Modify;

import java.sql.*;
import java.util.Scanner;

import com.tap.jdbc.MyConnection;

public class ModifyData {
	final static String sql ="update `student` set `department`=?,`mark`=? where `student_id`=?";
	static Connection con;
	static PreparedStatement pstmt;
	public static void main(String[] args) {
		
		try {
//			1.1&2 Load The Driver
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Model","root","mohanraj@123");
		  con = MyConnection.connect();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter the department");
			String department = sc.nextLine();
			System.out.println("Enter the Mark");
			int mark = sc.nextInt();
				
				System.out.println("Enter the student_id");
				int student_id = sc.nextInt();
				
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1,department);
				pstmt.setInt(2,mark);
				pstmt.setInt(3,student_id);
			
			

			int x = pstmt.executeUpdate();
			
			System.out.println(x+"rows updated");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
