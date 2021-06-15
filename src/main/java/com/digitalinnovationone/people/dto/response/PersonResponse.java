package com.digitalinnovationone.people.dto.response;

import java.util.List;

import com.digitalinnovationone.people.model.Phone;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonResponse {
	
	private String firstName;
	
	private String cpf;
	
	private List<Phone> phones;
	
}
