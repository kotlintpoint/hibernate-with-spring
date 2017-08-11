package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Circle;


public class CircleDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void insertCircle(Circle circle)
	{
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		session.save(circle);
		ts.commit();
		session.close();		
	}
}

