package com.serie4it.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.serie4it.sample.domain.Employee;
import com.serie4it.sample.service.EmployeeService;


public class App {
   static final Logger logger = LoggerFactory.getLogger(App.class);
   /**
    * @param args
    */
   public static void main(String[] args) {
      
      logger.info("load context");
      ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/applicationContext-bootstrap.xml");

      Employee em = new Employee();
      em.setId("1031");
      em.setName("Adam");
      em.setAge(25);

      EmployeeService emService = (EmployeeService) context.getBean("employeeService");
      emService.persistEmployee(em);
      
   }

}
