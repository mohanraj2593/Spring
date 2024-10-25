package com.tap.main;

import com.tap.entity.Employee;
import com.tap.manager.HibernateManager;

public class EmployeeMain {
public static void main(String[] args) {
	HibernateManager hm = new HibernateManager();
	hm.connect();
//	Employee e = new Employee(12,"Bharat","Developer",20000,"bharat@gmail.com","121212");
//	hm.add(e);
//	hm.fetchAll();
//	hm.fetchOnId(1);
	hm.fetchOnEmail("mohanraj25092003gmail.com");
//	hm.updateData(8, "kalaiselvan1@gmail.com");
//	hm.deleteData(3);
}
}
