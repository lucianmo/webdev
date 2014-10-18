package com.proj.journaldev.app;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proj.journaldev.dao.PersonDAO;
import com.proj.journaldev.model.Person;

public class SpringHibernateMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("journaldev/spring.xml");
		
		PersonDAO personDAO = context.getBean(PersonDAO.class);
		
		Person person = new Person();
		person.setName("Eva"); person.setCountry("Rai");
		
		personDAO.save(person);
		
		System.out.println("Person::"+person);
		
		List<Person> list = personDAO.list();
		
		for(Person p : list){
			System.out.println("Person List::"+p);
		}
		
		context.close();
		
	}

}
