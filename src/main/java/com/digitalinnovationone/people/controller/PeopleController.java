package com.digitalinnovationone.people.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinnovationone.people.dto.request.PersonRequest;
import com.digitalinnovationone.people.dto.response.PersonResponse;
import com.digitalinnovationone.people.model.Person;
import com.digitalinnovationone.people.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {
	
	private final PersonService personService;
	
	@Autowired
	public PeopleController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping
	public PersonResponse createPerson(@RequestBody @Valid PersonRequest form) {
		
		Person savedPerson = personService.save(form);
		
		return PersonResponse.builder()
				.firstName(savedPerson.getFirstName())
				.cpf(form.getCpf())
				.phones(form.getPhones())
				.build();
	}

}
