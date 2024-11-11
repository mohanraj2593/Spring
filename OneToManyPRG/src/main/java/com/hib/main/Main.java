package com.hib.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hib.entity.Softwares;
import com.hib.entity.TeamLeader;
import com.hib.entity.TeamMember;

public class Main {



private static Session session;
private static Transaction t;

public static void main(String[] args) {
	session=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TeamLeader.class)
			.addAnnotatedClass(TeamMember.class)
			.addAnnotatedClass(Softwares.class)
			.buildSessionFactory()
			.openSession();
	TeamLeader tl1 = new TeamLeader("Raju");
	TeamLeader tl2 = new TeamLeader("Ramu");
	
	TeamMember tm1 = new TeamMember("abc","dev");
	TeamMember tm2 = new TeamMember("mno","tester");
	TeamMember tm3 = new TeamMember("pqr","uiux");
	
	TeamMember tm4 = new TeamMember("stu","tester");
	TeamMember tm5 = new TeamMember("xyz","uiux");
	
//	tl1.addMember(tm1);
//	tl1.addMember(tm3);
//	tl1.addMember(tm5);
//	
//	tl2.addMember(tm2);
//	tl2.addMember(tm4);
	
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
