package com.hib.main;

import org.hibernate.Session
;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hib.entity.Softwares;
import com.hib.entity.TeamLeader;

public class Main {



private static Session session;
private static Transaction t;

public static void main(String[] args) {
	session=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TeamLeader.class)
			.addAnnotatedClass(Softwares.class)
			.buildSessionFactory()
			.openSession();
	TeamLeader tl1 = new TeamLeader("Raju");
	TeamLeader tl2 = new TeamLeader("Ramu");
	

	Softwares s1 = new Softwares("Learning Management System");
	Softwares s2 = new Softwares("Attendance Management System");
	Softwares s3 = new Softwares("Tap AI");
	
	tl1.addSoftwares(s1);
	tl1.addSoftwares(s2);
	tl1.addSoftwares(s3);
	
	tl2.addSoftwares(s2);
	tl2.addSoftwares(s3);
	
	session.beginTransaction();
	session.persist(tl1);
	session.persist(tl2);
	session.getTransaction().commit();
	System.out.println("Data Inserted Successfully");
	
	
	
	
	
	
	
}
}
