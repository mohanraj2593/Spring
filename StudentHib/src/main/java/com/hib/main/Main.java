package com.hib.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hib.entity.Student;
import com.hib.entity.StudentDetails;

public class Main {
private static Session session;
private static Transaction t;

public static void main(String[] args) {
	session=new Configuration().configure("student.xml").addAnnotatedClass(Student.class)
			.addAnnotatedClass(StudentDetails.class)
			.buildSessionFactory().openSession();
	Student s = session.get(Student.class, 52);
	s.getStudentDetails().setArea("MG Road");	
	session.beginTransaction();
	session.persist(s);
	session.getTransaction().commit();
	System.out.println("Data Set");
	
	
	
	
	
	
	
//	Student s = 
//	session.get(Student.class, 52);
//	System.out.println("Id: "+s.getSid());
//	System.out.println("Name: "+s.getName());
//	System.out.println("Email: "+s.getEmail());
//	System.out.println("Mobile: "+s.getMobile());
//	System.out.println("SDId: "+s.getStudentDetails().getSdid());
//	System.out.println("SD Area: "+s.getStudentDetails().getArea());
//	System.out.println("SD CITY: "+s.getStudentDetails().getCity());
//	System.out.println("S PIncode: "+s.getStudentDetails().getPincode());
	
	
	
	
	
//	Student s1 = new Student("sachin","sachin@gamil.com",98765645);
//	
//	StudentDetails sd = new StudentDetails("BTM","Banglore",560067);
//	s1.setStudentDetails(sd);
//	
//	t=session.beginTransaction();	
//	session.persist(s1);
//	t.commit();
//	System.out.println("Data Inserted");
}
}
