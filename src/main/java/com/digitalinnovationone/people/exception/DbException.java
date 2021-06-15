package com.digitalinnovationone.people.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DbException extends RuntimeException {

	private static final long serialVersionUID = -5795476948567651906L;

	public DbException(String msg) {
		super("msg");
	}
}
