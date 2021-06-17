package com.digitalinnovationone.people.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.digitalinnovationone.people.dto.request.PersonRequest;
import com.digitalinnovationone.people.model.Person;
import com.digitalinnovationone.people.repository.PersonRepository;
import com.digitalinnovationone.people.util.MyDateFormat;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	@Mock
	private PersonRepository personRepository;
	
	@InjectMocks
	private PersonService personService;
	
	@Test
	void testGivenPersonRequestThenReturnPerson() {
		PersonRequest personRequest = PersonRequest.builder()
				.firstName("Paulo")
				.lastName("Patarello")
				.cpf("152454521")
				.birthDate("24/02/2001")
				.build();
		Person persontoSave = Person.builder()
				.id(null)
				.firstName("Paulo")
				.lastName("Patarello")
				.cpf("152454521")
				.birthDate(MyDateFormat.toLocalDate("24/02/2001"))
				.build();
		
		Mockito.when(personRepository.save(persontoSave)).thenReturn(persontoSave);
		
		Person savedPerson = personService.save(personRequest);
		savedPerson.setId(1L);
		
		Assertions.assertEquals(savedPerson, persontoSave);
	}
	
}
