package com.serie4it.sample.repository;

import java.util.List;

import com.serie4it.sample.domain.Person;

public interface PersonDAO {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);
}
