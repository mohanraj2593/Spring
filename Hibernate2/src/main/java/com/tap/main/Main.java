package com.tap.main;

import java.lang.module.Configuration;

import com.tap.entity.Employee;
import com.tap.manager.HibernamteManager;

public class Main {
	private static Configuration session;

	public static void main(String[] args) {
		HibernamteManager hm = new HibernamteManager();
		hm.connect();
//		Employee e = new Employee(13,"Ganesh1","Java",40000,"ganesh1@gmail.com","121212");
//		hm.add(e);
//		hm.fetchAll();
//		hm.fetchOnId(1);
//		hm.fetchOnEmail("ganesh1@gamil.com");
//		hm.update(4, "sujay1@gmail.com");
		hm.delete(9);
		
		
	}

}
