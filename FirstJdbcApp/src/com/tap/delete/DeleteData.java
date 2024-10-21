package com.tap.delete;
import java.sql.*;
import java.util.Scanner;

public class DeleteData {
	static Connection con;
	static PreparedStatement pstmt;
	public static void main(String[] args) {
		String sql = "delete from student where student_id=?";
		// TODO Auto-generated method stub
	try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Student Id");
		int student_id=sc.nextInt();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Model","root","mohanraj@123");
		 pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,student_id);
		
		int x = pstmt.executeUpdate();
		System.out.println(x+"rows updated");
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		try {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	}
	
	
		
		
		
		
		
		
		

	}

}
