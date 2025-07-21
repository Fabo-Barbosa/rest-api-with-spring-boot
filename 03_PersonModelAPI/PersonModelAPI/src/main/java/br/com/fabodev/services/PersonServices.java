package br.com.fabodev.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.fabodev.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private final Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		
		List<Person> people = new ArrayList<Person>();
		for(int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			people.add(person);
		}
		
		return people;
	}
	
	public Person getById(String id) {
		
		logger.info("Finding new person by id!");
		
		Person person = new Person();
		person.setId(counter.getAndIncrement());
		person.setFirstName("Fábio");
		person.setLastName("Barbosa");
		person.setAddress("Rua Castelo Branco, nº 57- Paracuri");
		person.setGender("Male");
		
		return person;
	}
	
	public Person create(Person person) {
		logger.info("Creating person...");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating person...");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Updating person...");
	}
	
	private Person mockPerson(int i) {
		
		logger.info("Finding all people!");
		
		Person person = new Person();
		person.setId(counter.getAndIncrement());
		person.setFirstName("First Name " + i);
		person.setLastName("Last Name " + i);
		person.setAddress("Address " + i);
		person.setGender("Male " + i);
		
		return person;
	}

}

