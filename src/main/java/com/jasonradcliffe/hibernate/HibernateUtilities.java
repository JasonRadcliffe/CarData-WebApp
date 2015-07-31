package com.jasonradcliffe.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilities {
	
	private static SessionFactory sessionFactory;	
	private static ServiceRegistry serviceRegistry;
	
	
	@SuppressWarnings("deprecation")
	public static SessionFactory getSessionFactory(String user, String pass){
		
		try{
			
			Configuration configuration = new Configuration().configure();
			
			configuration.setProperty("hibernate.connection.username", user);
			configuration.setProperty("hibernate.connection.password", pass);
			
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
		}
		catch(HibernateException exception){
			System.out.println("Problem creating session factory");
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			exception.printStackTrace();
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		}
		
		return sessionFactory;
	}
	
	
	

}
