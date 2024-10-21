package com.tap.bank;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Authenticate1 {
	static int pin=121212;
public static void Verify(Scanner scan,Connection con){
	System.out.println("Enter The Upin");
	int Upin=scan.nextInt();
	if(pin==Upin) {
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else {
		try {
			con.rollback();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
}
