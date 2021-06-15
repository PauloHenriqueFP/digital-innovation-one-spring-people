package com.digitalinnovationone.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalinnovationone.people.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
