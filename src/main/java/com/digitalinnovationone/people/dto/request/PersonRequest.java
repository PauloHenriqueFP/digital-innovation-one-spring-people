package com.digitalinnovationone.people.dto.request;

import java.time.LocalDate;
import java.util.List;

import com.digitalinnovationone.people.model.Phone;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonRequest {
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String cpf;
	
	private LocalDate birthDate;
	
	private List<Phone> phones;
	
}
