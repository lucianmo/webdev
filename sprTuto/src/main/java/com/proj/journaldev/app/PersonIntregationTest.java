package com.proj.journaldev.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proj.journaldev.dao.PersonDAO;
import com.proj.journaldev.model.Person;

public class PersonIntregationTest {

   private static final Logger logger = LoggerFactory.getLogger(PersonIntregationTest.class);
   
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("journaldev/springPerson.xml");
		
		PersonDAO personDAO = context.getBean(PersonDAO.class);
		
		Person person = new Person();
		person.setName("Eva"); person.setCountry("Rai");
		
		personDAO.save(person);
		
		logger.info("   >>> Person::"+person);
		
		List<Person> list = personDAO.list();
		
		for(Person p : list){
		   logger.info("   >>> Person List::"+p);
		}
		
		context.close();
		
	}

}
