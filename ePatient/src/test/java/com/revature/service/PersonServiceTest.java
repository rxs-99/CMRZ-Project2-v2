package com.revature.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

import com.revature.dao.PersonDAO;
import com.revature.model.Person;

public class PersonServiceTest {

	@InjectMocks
	public static PersonService ps;

	@Mock
	public PersonDAO pdao;
	
	public static Person testPerson = new Person(
		1,
		"Test Person",
		"555-555-5555",
		"person@email.com",
		null
	);
	
	public static Person testDoctor = new Person(
		2,
		"Test Doctor",
		"777-777-7777",
		"doctor@email.com",
		null
	);
	
	@Before
	public void initPersonDAO() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testCreatePersonSuccess() {
		Mockito.when(pdao.createPerson(testPerson)).thenReturn(true);
		
		ps = new PersonService(pdao);
		boolean success = ps.createPerson(testPerson);
		assertEquals(true, success);
	}
	
	@Test
	public void testCreatePersonFailNoName() {
		Person badPerson = new Person(
			1,
			null,
			"555-555-5555",
			"person@email.com",
			null
		);
		Mockito.when(pdao.createPerson(badPerson)).thenReturn(true);
		
		ps = new PersonService(pdao);
		boolean success = ps.createPerson(badPerson);
		assertEquals(false, success);
	}
	
	@Test
	public void testCreatePersonFailBadEmail() {
		Person badPerson = new Person(
			1,
			"Test Person",
			"555-555-5555",
			"bademail",
			null
		);
		Mockito.when(pdao.createPerson(badPerson)).thenReturn(true);
		
		ps = new PersonService(pdao);
		boolean success = ps.createPerson(badPerson);
		assertEquals(false, success);
	}
	
	@Test
	public void testCreatePersonFailBadPhone() {
		Person badPerson = new Person(
			1,
			null,
			"badnumber24341",
			"person@email.com",
			null
		);
		Mockito.when(pdao.createPerson(badPerson)).thenReturn(true);
		
		ps = new PersonService(pdao);
		boolean success = ps.createPerson(badPerson);
		assertEquals(false, success);
	}
	
	@Test
	public void testGetPersonInfo() {

		int personId = testPerson.getId();
		Mockito.when(pdao.getPersonInfo(personId)).thenReturn(testPerson);
		
		ps = new PersonService(pdao);
		Person retrievedPerson = ps.getPersonInfo(personId);
		assertEquals(testPerson, retrievedPerson);
	}
	
	@Test
	public void testUpdatePersonInfoSuccess() {
		Mockito.when(pdao.updatePersonInfo(testPerson)).thenReturn(true);
		
		ps = new PersonService(pdao);
		boolean success = ps.updatePersonInfo(testPerson);
		assertEquals(true, success);
	}
	
	@Test
	public void testUpdatePersonInfoFailNoName() {
		Person badPerson = new Person(
			1,
			null,
			"555-555-5555",
			"person@email.com",
			null
		);
		Mockito.when(pdao.updatePersonInfo(badPerson)).thenReturn(true);
		
		ps = new PersonService(pdao);
		boolean success = ps.updatePersonInfo(badPerson);
		assertEquals(false, success);
	}
	
	@Test
	public void testUpdatePersonInfoFailBadEmail() {
		Person badPerson = new Person(
			1,
			"Test Person",
			"555-555-5555",
			"bademail",
			null
		);
		Mockito.when(pdao.updatePersonInfo(badPerson)).thenReturn(true);
		
		ps = new PersonService(pdao);
		boolean success = ps.updatePersonInfo(badPerson);
		assertEquals(false, success);
	}
	
	@Test
	public void testUpdatePersonInfoFailBadPhone() {
		Person badPerson = new Person(
			1,
			null,
			"badnumber24341",
			"person@email.com",
			null
		);
		Mockito.when(pdao.updatePersonInfo(badPerson)).thenReturn(true);
		
		ps = new PersonService(pdao);
		boolean success = ps.updatePersonInfo(badPerson);
		assertEquals(false, success);
	}
}
