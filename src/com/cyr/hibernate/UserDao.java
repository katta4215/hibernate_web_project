package com.cyr.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.mysql.cj.Session;

public class UserDao {
	public static int register(User u){    
		 int i=0;    
		  
		 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		 Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		org.hibernate.Session session = factory.openSession();  
		Transaction t = session.beginTransaction();   
		  
		i=(Integer)session.save(u);    
		  
		t.commit();    
		session.close();    
		    
		return i;    
		   
		 }    
}
