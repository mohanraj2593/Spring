package com.tap.Classes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tap.Interface.Trainer;

public class WebTrainer implements Trainer {
	private String name;
	private String message;
	private PracticeTime pt;

	@Override
	public String givTask() {
		
		return name +" provide "+ message+" for "+pt.getPracticeTime();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("Name3 dependency is injucted");
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		System.out.println("Message3 dependency is injucted");
		this.message = message;
	}
	public PracticeTime getPt() {
		return pt;
	}
	public void setPt(PracticeTime pt) {
		System.out.println("Practice Time3 dependency is injucted");
		this.pt = pt;
	}
	public void webTrainerInit() {
		System.out.println("Init3 method is created");
	}
	public void webTrainerDestroy() {
		System.out.println("Destroy3 method is created");
	}
	public WebTrainer() {
System.out.println("Web Trainer is Created ");
	}

}
