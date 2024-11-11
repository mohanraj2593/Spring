package com.tap.Classes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tap.Interface.Trainer;

public class SqlTrainer implements Trainer {
	private String name;
//	public SqlTrainer(String name, String message) {
//		super();
//		this.name = name;
//		this.message = message;
//	}
	private String message;
	PracticeTime pt;
	@Override
	public String givTask() {
		
		return name +" provide "+message+" for "+pt.getPracticeTime();
	}
	public PracticeTime getPt() {
		return pt;
	}
	public void sqlTrainerInit() {
		System.out.println("Init2 method is created");
	}
	public void sqlTrainerDestroy() {
		System.out.println("Destroy2 method is created");
	}
public SqlTrainer() {
		System.out.println("SqlTrainer created");
	}

	public void setPt(PracticeTime pt) {
		System.out.println("Practice Time2 created");
		this.pt = pt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("Name2 dependency is injucted");
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		System.out.println("Message2 dependency is injucted");
		this.message = message;
	}

}
