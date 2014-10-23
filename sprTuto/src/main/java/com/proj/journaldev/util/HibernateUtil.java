package com.proj.journaldev.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HibernateUtil {

   private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
   
	//Annotation based configuration
	private static SessionFactory sessionAnnotationFactory;

   private static SessionFactory buildSessionAnnotationFactory() {
    	try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration configuration = new Configuration();
        	configuration.configure("journaldev/hibernate-annotation.cfg.xml");
        	logger.info("Hibernate Annotation Configuration loaded");
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	logger.info("Hibernate Annotation serviceRegistry created");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            logger.info("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}

    	
	public static SessionFactory getSessionAnnotationFactory() {
		if(sessionAnnotationFactory == null) sessionAnnotationFactory = buildSessionAnnotationFactory();
        return sessionAnnotationFactory;
    }
		
}
