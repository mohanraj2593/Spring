package com.tap.Main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tap.Classes.GoldCustomer;
import com.tap.Classes.PlatinumCustomer;
import com.tap.Interface.*;

public class Main {
public static void main(String[] args) {
	ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("beans.xml");
	        Customer g =(GoldCustomer)cp.getBean("gold");
			Customer p =(PlatinumCustomer)cp.getBean("plat");
			
			
		g.showDetails();
		p.showDetails();
}
}
