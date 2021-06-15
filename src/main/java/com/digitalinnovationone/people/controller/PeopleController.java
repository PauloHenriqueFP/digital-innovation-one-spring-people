package com.digitalinnovationone.people.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@GetMapping
	public List<PersonResponse>listAll() {
		return personService.getAll().stream().map(this::toPersonResponse).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public PersonResponse getById(@PathVariable(required = true, name = "id") Long id) {
		
		Person person = personService.findById(id);
		
		return toPersonResponse(person);
	}

	@PostMapping @ResponseStatus(HttpStatus.CREATED)
	public PersonResponse createPerson(@RequestBody @Valid PersonRequest form) {
		
		Person savedPerson = personService.save(form);
		
		return toPersonResponse(savedPerson);
	}
	
	@PutMapping("/{id}")
	public PersonResponse update(@PathVariable(required = true, name = "id") Long id, @RequestBody @Valid PersonRequest form) {
		Person updatedPerson = personService.update(id, form);
		
		return toPersonResponse(updatedPerson);
	}
	
	@DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(required = true, name = "id") Long id) {
		
		personService.deleteById(id);
		
	}
	
	private PersonResponse toPersonResponse(Person person) {
		
		return PersonResponse.builder()
				.firstName(person.getFirstName())
				.cpf(person.getCpf())
				.phones(person.getPhones())
				.build();
	}

}
