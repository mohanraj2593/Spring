package com.tap.manager;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.entity.Employee;
public class HibernateManager {
private static Configuration config;
private static SessionFactory sf;
private static Session session;
private Transaction t;
private List<Employee> employeeList;

public void connect(){
	
	session=new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory().openSession();
	System.out.println(session);
	
}

public void add(Employee e) {
	t=session.beginTransaction();
	session.persist(e);
	t.commit();
	}
public  void fetchAll(){
	employeeList=session.createQuery("from Employee").list();
	for(Employee e:employeeList) {
		System.out.println(e);
	}
}
public void fetchOnId(int id){
	Employee e=session.get(Employee.class,id);
	System.out.println(e);
	}
public void fetchOnEmail(String email) {
	employeeList=session.createQuery("from Employee where email='"+email+"'",Employee.class)
			.list();
	for(Employee e:employeeList) {
		System.out.println(e);
	}
}
public void updateData(int id,String email) {
	t=session.beginTransaction();
	Employee e = session.get(Employee.class,id);
	if(e!=null) {
		e.setEmail(email);
		session.persist(e);
		t.commit();
		System.out.println("Updated");
	}
}
	public void deleteData(int id) {
		t=session.beginTransaction();
		Employee e = session.get(Employee.class,id);
		session.delete(e);
		t.commit();
		System.out.println("Data Deleted");
	}
	
}






