package com.digitalinnovationone.people.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinnovationone.people.dto.request.PersonRequest;
import com.digitalinnovationone.people.model.Person;
import com.digitalinnovationone.people.repository.PersonRepository;
import com.digitalinnovationone.people.util.MyDateFormat;

@Service
public class PersonService {

	private final PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public Person save(PersonRequest form) {
		Person person = Person.builder()
				.firstName(form.getFirstName())
				.lastName(form.getLastName())
				.cpf(form.getCpf())
				.birthDate(MyDateFormat.toLocalDate(form.getBirthDate()))
				.phones(form.getPhones())
				.build();
		
		Person savedPerson = personRepository.save(person);
		return savedPerson;
	}
	
}
