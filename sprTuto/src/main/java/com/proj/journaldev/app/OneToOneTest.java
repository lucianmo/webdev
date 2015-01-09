package com.proj.journaldev.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proj.journaldev.model.Student;
import com.proj.journaldev.model.StudentInformation;
import com.proj.journaldev.util.HibernateUtil;

public class OneToOneTest {

   private static final Logger logger = LoggerFactory.getLogger(OneToOneTest.class);
   /**
    * @param args
    */
   public static void main(String[] args) {
      Student student = new Student();
      
      student.setStudentName("Alaska");
      student.setStudentAge("19");
      
      StudentInformation studentInfo = new StudentInformation();

      studentInfo.setAddress("1st Street");
      studentInfo.setPhoneNumber("652.958.6521");
      studentInfo.setRegistryNumber("ax203");
      studentInfo.setEnlisted(new Date());

      studentInfo.setStudent(student);
      student.setStudentInfo(studentInfo);
      
      //Get Session
      SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
      Session session = sessionFactory.getCurrentSession();
      //start transaction
      session.beginTransaction();
      
      //Save the Model object
      session.save(student);
      
      //Commit transaction
      session.getTransaction().commit();
      logger.info("   >>> Student ID="+student.getStudentId());
      
      //terminate session factory, otherwise program won't end
      sessionFactory.close();      
   }

}
