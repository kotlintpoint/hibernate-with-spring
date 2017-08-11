package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.CircleDAO;
import com.model.Circle;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		CircleDAO dao=context.getBean("circleDao",CircleDAO.class);
		dao.insertCircle(new Circle(1, "Circle 1"));
	}

}
