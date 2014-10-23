package com.proj.journaldev.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proj.journaldev.model.EmployeeAnnotated;
import com.proj.journaldev.util.HibernateUtil;

public class EmploeeAnnotationTest {

   private static final Logger logger = LoggerFactory.getLogger(EmploeeAnnotationTest.class);
   /**
    * @param args
    */
   public static void main(String[] args) {
      EmployeeAnnotated emp = new EmployeeAnnotated();
      emp.setName("David");
      emp.setRole("Developer");
      emp.setInsertTime(new Date());
      
      //Get Session
      SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
      Session session = sessionFactory.getCurrentSession();
      //start transaction
      session.beginTransaction();
      //Save the Model object
      session.save(emp);
      //Commit transaction
      session.getTransaction().commit();
      logger.info("Employee ID="+emp.getId());
      
      //terminate session factory, otherwise program won't end
      sessionFactory.close();
   }

}
