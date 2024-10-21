package com.tap.bank;

import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;

public class BankACID {
	static String url="jdbc:mysql://localhost:3306/bank";
	static String UserName="root";
	static String Password="mohanraj@123";
	static ResultSet result;
	static Connection con;
	static Statement stmt;
	static PreparedStatement pstmt;
	static String SQL="select * from bank";
	static String SENDER_AC="update bank set balance=balance-? where accno=?";
	static String RECEIVER_AC="update bank set balance=balance+? where accno=?";
	static Scanner scan = new Scanner(System.in);
	static Scanner scan1 = new Scanner(System.in);
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,UserName,Password);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
public static void main(String[] args) {
try {
	for(int i=1;i<=3;i++) {
	con.setAutoCommit(false);
	disp();
	pstmt=con.prepareStatement(SENDER_AC);
	System.out.println("Enter The sender acc No");
	String Sender_Ac=scan1.nextLine();
	
	System.out.println("Enter The Amount ");
	String Amount=scan1.nextLine();
	pstmt.setString(1, Amount);
	pstmt.setString(2, Sender_Ac);
	
	
	 int x =pstmt.executeUpdate();
	System.out.println(Sender_Ac+" from deduct amount "+Amount+" are "+x+" dedued successfully");
	
	//RECEIVE
	pstmt=con.prepareStatement(RECEIVER_AC);
	System.out.println("Enter The Receiver Ac Number");
	String Receiver_Ac=scan1.nextLine();
	pstmt.setString(1, Amount);
	pstmt.setString(2, Receiver_Ac);
	  x=pstmt.executeUpdate();
	 System.out.println(Receiver_Ac+" add credit amount "+Amount+"are"+x+"Added Sucessfully");
	 Authenticate1.Verify( scan, con);
//	 con.commit();
	 
	
	 //SELECT
}
}
	

catch(Exception e) {
	e.printStackTrace();
}
disp();
}
 static void disp(){
try {
	 stmt=con.createStatement();
	 result=stmt.executeQuery(SQL);
	 while(result.next()) {
		 System.out.println(result.getInt(1)+" "
				 +result.getString(2)+" "
				 +result.getString(3)+" "
				 +result.getString(4));
	 }
}
	
catch(Exception e) {
	e.printStackTrace();
}
 }

	
	

}
