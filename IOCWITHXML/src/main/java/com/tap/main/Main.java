package com.tap.main;

import com.tap.interfaces.Trainer;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tap.classes.JavaTrainer;
import com.tap.classes.SqlTrainer;
import com.tap.classes.WebTrainer;

public class Main {
public static void main(String[] args) {
try (ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("beans.xml")) {
	Trainer jt =(JavaTrainer)cpx.getBean("javaT");
	Trainer st =(SqlTrainer)cpx.getBean("sqlT");
	Trainer wt =(WebTrainer)cpx.getBean("webT");
    System.out.println(jt.giveTask());
	System.out.println(st.giveTask());
	System.out.println(wt.giveTask());
} catch (BeansException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
}
}
