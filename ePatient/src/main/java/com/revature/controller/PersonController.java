package com.revature.controller;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Person;
import com.revature.service.PersonService;

@RestController("personController")
@RequestMapping("/person")
public class PersonController {
	private PersonService ps;

	@Autowired
	public PersonController(PersonService ps) {
		this.ps = ps;
	}
	
	@GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Person> getPerson(@PathVariable int id) {
		return new ResponseEntity<Person>(ps.getPatientInfo(id), HttpStatus.OK);
	}
}
