package com.ioc.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ioc.Classes.GoldCustomer;
import com.ioc.Classes.PlatinumCustomer;

public class Launch {
public static void main(String[] args) {
	ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("beans.xml");
	GoldCustomer gc =(GoldCustomer)cpx.getBean("goldCustomer");
	PlatinumCustomer pc =(PlatinumCustomer)cpx.getBean("platinumCustomer");
	gc.disp();
	pc.disp();
	
}
}
