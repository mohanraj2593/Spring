package com.tap.manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.entity.Employee;

public class HibernamteManager {
private Session session;
List<Employee> empList;
private Transaction t;

public void connect(){
	session=new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory().openSession();
}
public void add(Employee e) {
	t=session.beginTransaction();
	session.persist(e);
	t.commit();
}
public void fetchAll(){
	empList=session.createQuery("from Employee").list();
	for(Employee e:empList) {
		System.out.println(e);
	}
}
	public void fetchOnId(int id) {
		Employee e=
		session.get(Employee.class, id);
		System.out.println(e);
	
}
	public void fetchOnEmail(String email) {
		empList=session.createQuery("from Employee where email= ' "+email+" ' ").list();
		for(Employee e:empList) {
			System.out.println(e);
		}
	}
	public void update(int id,String email) {
		t=session.beginTransaction();
		Employee e = session.get(Employee.class, id);
		if(e!=null) {
			e.setEmail(email);
			session.persist(e);
			t.commit();
			System.out.println("data Updated");
		}
		else {
			System.out.println("No such data found");
		}
	}
	public void delete(int id) {
		session.beginTransaction();
		Employee e = session.get(Employee.class, id);
		session.delete(e);
		session.getTransaction().commit();
		System.out.println("Data Deleted Sucessfully");
		
	}
}
