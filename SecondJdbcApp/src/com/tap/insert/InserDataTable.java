package com.tap.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.Scanner;

public class InserDataTable {
	static Scanner scan
	= new Scanner(System.in);
	static Scanner scan1
	= new Scanner(System.in);

	static Connection con;
	static Statement stmt;
    static  PreparedStatement pstmt;
    static ResultSet result;
    static ResultSetMetaData rsmd;
	static String INSERT="insert into student(name,mark,department,student_id) values(?,?,?,?)";
	static String SELECT="select * from student";
	static String UPDATE="update student set department=? where student_id=?";
	static String DELETE="delete from student where student_id=?";
	static String META_DATA="select * from student";
	static String ADD_BATCH="insert into student(name,mark,department,student_id) values(?,?,?,?)";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Model","root","mohanraj@123");
	
			 
			 //ADD_BATCH
			 System.out.println("Enter the Number odf Student Insert ");
			 int n=scan.nextInt();
			 pstmt=con.prepareStatement(ADD_BATCH);
			 for(int i=1;i<=n;i++) {
			 System.out.println("Enter The Insert Name");
			 String name=scan1.nextLine();
			 System.out.println("Enter The Mark ");
			 int mark=scan.nextInt();
			 System.out.println("Enter The department Name");
			 String department=scan1.nextLine();
			 System.out.println("Enter The student_id");
			 int student_id=scan.nextInt();
			pstmt.setString(1, name);
			pstmt.setInt(2, mark);
			pstmt.setString(3,department);
			pstmt.setInt(4, student_id);
			pstmt.addBatch();
			
			System.out.println(i+" Query Eecuted Successfully");
			 }
			pstmt.executeBatch();
			System.out.println("Batch Executed successfully");
			
			 //META-DATA
			 stmt=con.createStatement();
			 result=stmt.executeQuery(META_DATA);
			 rsmd=result.getMetaData();
			int count=rsmd.getColumnCount();
			for(int i=1;i<=count;i++) {
				System.out.println(rsmd.getColumnName(i)+" "+rsmd.getColumnTypeName(i)+" "+rsmd.getColumnType(i));
			}
			for(int i=1;i<=count;i++) {
				System.out.printf("%-12s",rsmd.getColumnName(i));
				
			}
			
			System.out.println();
			 while(result.next()) {
				 System.out.printf("%-12s %-12d %-12s %-12d%n",
						 result.getString(1),
						 result.getInt(2),
						 result.getString(3),
						 result.getInt(4));
			 }
			 System.out.println();
			 System.out.println();
			 
			
			 //INSERT
			 pstmt=con.prepareStatement(INSERT);
			 System.out.println("Enter The Student Name");
			 String name =scan1.nextLine();
			 System.out.println("Enter The Student Mark");
			 int mark =scan.nextInt();
			 System.out.println("Enter The Student Department");
			String department=scan1.nextLine();
			 System.out.println("Enter The Student student_id");
			 int student_id =scan.nextInt();
			 pstmt.setString(1,name);
			 pstmt.setInt(2,mark);
			 pstmt.setString(3,department);
			 pstmt.setInt(4, student_id);
			 
			
			 
			 int x=pstmt.executeUpdate();
			System.out.println(x+"rows are inserted");	
			//READ-SELECT
			 stmt=con.createStatement();
			 result=stmt.executeQuery(SELECT);
			 while(result.next()) {
				 System.out.println(result.getString(1)+"   "
						 +result.getInt(2)+"   "
						 +result.getString(3)+"   "
						 +result.getInt(4));
			 }
			
			
			
			
		//UPDATE
			 System.out.println("Enter The Student student_id");
			   student_id =scan.nextInt();
			 System.out.println("Enter The Student Department");
			  department=scan1.nextLine();
			
			pstmt=con.prepareStatement(UPDATE);
			pstmt.setString(1, department);
			pstmt.setInt(2, student_id);
			  x=pstmt.executeUpdate();
			 System.out.println(x+"Rows are Updated");
			 
			
			 
			
		
		
				
				 
				 //DELETE
				 pstmt=con.prepareStatement(DELETE);
				 System.out.println("Enter The Deleting Student_id");
				  student_id=scan.nextInt();
				  pstmt.setInt(1,student_id);
				  x=pstmt.executeUpdate();
				  System.out.println(x+"are Deleted");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
