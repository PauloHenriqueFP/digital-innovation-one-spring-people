package com.digitalinnovationone.people.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1490267201607970027L;

	public PersonNotFoundException(Long id) {
		super("Person with id: " + id + " was not found");
	}
}
