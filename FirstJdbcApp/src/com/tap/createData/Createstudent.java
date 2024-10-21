package com.tap.createData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.tap.jdbc.MyConnection;

public class Createstudent {
	private static String sql = "insert into student(student_id,name,mark,department)" +"values(?,?,?,?)";
	static Connection con;
	static PreparedStatement pstmt;
	static ResultSet result;
	public static void main(String args[]) {
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter the student student_id ");
			int student_id=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter the student name ");
			String name=sc.nextLine();
			System.out.print("Enter the student mark ");
			int mark=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter the student department ");
			String department=sc.nextLine();
			
			
//			1.Load driver and Establish connection
			con = MyConnection.connect();
//			3.create Statement
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,student_id);
			pstmt.setString(2,name);
			pstmt.setInt(3,mark);
			pstmt.setString(4,department);
			
			
			
			int x=pstmt.executeUpdate();
			System.out.println(x+"rows upated");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	

}
