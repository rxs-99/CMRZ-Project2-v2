package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Person;
import com.revature.service.PersonService;

@RestController("personController")
@RequestMapping("/person")
@CrossOrigin
public class PersonController {
	private PersonService ps;

	@Autowired
	public PersonController(PersonService ps) {
		this.ps = ps;
	}
	
	@GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Person> getPerson(@PathVariable int id) {
		return new ResponseEntity<Person>(ps.getPersonInfo(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/get_doctors", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Person>> getAllDoctors() {
		return new ResponseEntity<List<Person>>(ps.getAllDoctors(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/get/patients", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Person>> getAllPatients() {
		return new ResponseEntity<List<Person>>(ps.getAllPatients(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/edit", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void editPerson(@RequestBody Person newPerson) {
		ps.updatePersonInfo(newPerson);
	}
}
