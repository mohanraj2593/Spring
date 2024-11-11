package com.hib.main;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.hib.entity.Course;
import com.hib.entity.Student;
import com.hib.entity.StudentDetails;

public class Main {
private static Session session;

public static void main(String[] args) {
	session = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(StudentDetails.class)
			.addAnnotatedClass(Course.class)
			.buildSessionFactory()
			.openSession();
	
	
	
	
	
	Student s = new Student("Virat","virat@gmail.com",111111);
	StudentDetails sd = new StudentDetails("MG Road","C",357664);
	s.setStudentDetails(sd);
	
	
	
	
	Course c1 = new Course("HTML",10);
	Course c2 = new Course("CSS",15);
	Course c3 = new Course("JS",30);
	s.addCoure(c1);
	s.addCoure(c2);
	s.addCoure(c3);

	
	
	
	session.beginTransaction();
	session.persist(s);
	session.getTransaction().commit();
	
	
//	StudentDetails  = session.get(StudentDetails.class, 2);
//	System.out.println(sd.getSdid()+" "
//			+sd.getArea()+" "
//			+sd.getCity()+" "
//			+sd.getPincode());
//	
//	Student s= sd.getStudent();
//	System.out.println(s.getSid()+" "
//			+s.getName()+" "
//			+s.getEmail()+" "
//			+s.getMobile());
//	
//	
//	
	
	
	
	
	
	

	
	
}
}
