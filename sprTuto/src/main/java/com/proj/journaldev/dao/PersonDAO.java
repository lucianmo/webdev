package com.proj.journaldev.dao;

import java.util.List;

import com.proj.journaldev.model.Person;

public interface PersonDAO {

	public void save(Person p);
	
	public List<Person> list();
	
}
