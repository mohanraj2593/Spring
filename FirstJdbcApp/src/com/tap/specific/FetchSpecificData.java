package com.tap.specific;
import com.tap.jdbc.MyConnection;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchSpecificData {
	private static String sql = "select * from student where student_id=?";
	static Connection con;
	static PreparedStatement pstmt;
	static ResultSet result;
	public static void main(String args[]) {
		try {
			System.out.println("Enter the student_id ");
			int student_id =new Scanner(System.in).nextInt();
//			1.Load driver and Establish connection
			con = MyConnection.connect();
//			3.create Statement
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,student_id);
			result=pstmt.executeQuery();
			if(result.next()) {
				System.out.println(result.getString("name")+"   "
			+result.getInt("mark")+"   "
						+result.getString("department")+" "
			+result.getInt("student_id"));
				
			}
			else {
				System.out.println("no record founds");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	

}
