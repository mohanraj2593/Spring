package com.tap.Main;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tap.Classes.JavaTrainer;
import com.tap.Classes.SqlTrainer;
import com.tap.Classes.WebTrainer;
import com.tap.Interface.*;

public class Main {
public static void main(String[] args) {
	ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("beans.xml");
	
	
	
	JavaTrainer jt= (JavaTrainer)cpx.getBean("javaT");
	
	
	   SqlTrainer st =  (SqlTrainer)cpx.getBean("sqlT");
	   WebTrainer wt = (WebTrainer)cpx.getBean("webT");
//	  jt.setName("java trainer1");
//	  jt.setMessage("Java Trining");
//	  st.setName("sql trainer1");
//	  st.setMessage("sql training");
//	  wt.setName("web trainer1");
//	  wt.setMessage("web training");
//	Trainer jt = new JavaTrainer();
//Trainer st =  new SqlTrainer();
//Trainer wt = new WebTrainer();
   System.out.println(jt.givTask());
   System.out.println(st.givTask());
   System.out.println(wt.givTask());
   cpx.close();
}
}
