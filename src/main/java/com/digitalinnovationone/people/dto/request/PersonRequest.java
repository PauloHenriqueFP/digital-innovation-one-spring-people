package com.digitalinnovationone.people.dto.request;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.digitalinnovationone.people.model.Phone;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonRequest {
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@CPF
	@NotBlank
	private String cpf;
	
	private String birthDate;
	
	@NotEmpty
	private List<Phone> phones;
	
}
