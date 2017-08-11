package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.model.Circle;


public class CircleDAOHibernateTemplate extends HibernateDaoSupport{

	@Transactional(readOnly=false)
	public void insertCircle(Circle circle)
	{
		getHibernateTemplate().save(circle);
		System.out.println("Circle Saved");
	}
	
 	@Transactional(readOnly=true)
    public List<?> findCircles() {
        List<?> circlesList = getHibernateTemplate().find("from Circle where id = ?", new Object[]{1});
        System.out.println("Circles found: " + circlesList.size());
        return circlesList;
    }
     
    @Transactional(readOnly=false)
    public void deleteEmployees(List<?> circlesList) {        
        if (!circlesList.isEmpty()) {
            getHibernateTemplate().deleteAll(circlesList);
            System.out.println("Circles deleted");
        }
    }
      
    @Transactional(readOnly=false)
    public void createCircle(final int id, final String Name){
        System.out.println("Create new Circle " + Name);
        Circle circle=getHibernateTemplate().execute(new HibernateCallback<Circle>() {
        	@Override
        	public Circle doInHibernate(Session session) throws HibernateException {
        		// TODO Auto-generated method stub
               	Circle circle = new Circle();
               	circle.setId(id);
               	circle.setName(Name);
                session.saveOrUpdate(circle);
                return circle;
        	}
		});	        
        System.out.println("Employee created " + circle);
    }
	
}

