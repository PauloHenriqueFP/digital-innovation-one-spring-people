package com.digitalinnovationone.people.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyDateFormat {
	public static LocalDate toLocalDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(date, formatter);
	}
}
