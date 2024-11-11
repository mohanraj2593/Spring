package com.tap.daoimpl;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.tap.entity.User;

public class UserDaoImpl {


private Session session;

public UserDaoImpl() {
	session=new Configuration().configure().addAnnotatedClass(User.class)
	.buildSessionFactory()
	.openSession();
	}
public void register(User user) {
	session.beginTransaction();
	session.persist(user);
	session.getTransaction();
	
	
}
}
