package com.tap.Classes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tap.Interface.Trainer;

public class JavaTrainer implements Trainer {
	private String name;
	private String message;
	private PracticeTime pt;
	public String givTask() {
		
	
		return name +" provide "+ message+" for "+pt.getPracticeTime();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("Name1 dependency is injucted");
		this.name = name;
	}
	public String getMessage() {
		
		return message;
	}
	public void setMessage(String message) {
		System.out.println("Message1 dependency is injucted");
		this.message = message;
	}
	public PracticeTime getPt() {
		return pt;
	}
	public void setPt(PracticeTime pt) {
		System.out.println("Practice Time1 dependency is injucted");
		this.pt = pt;
	}
	public void javaTrainerInit() {
		System.out.println("Init1 method is created");
	}
	public void javaTrainerDestroy() {
		System.out.println("Destroy1 method is created");
	}
	public JavaTrainer() {
		System.out.println("Java Trainer Bean is Created");
	}
}
