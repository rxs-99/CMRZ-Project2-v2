package com.revature.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.revature.dao.PersonDAO;
import com.revature.model.Person;

public class PersonServiceTest {

	@InjectMocks
	public static PersonService ps;

	@Mock
	public PersonDAO pdao;
	
	public static Person testPatient = new Person(
		1,
		"Test Patient",
		"555-555-5555",
		"patient@email.com",
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
	public void initPatientDAO() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testGetPatientInfo() {

		int patientId = testPatient.getId();
		Mockito.when(pdao.getPatientInfo(patientId)).thenReturn(testPatient);
		
		ps = new PersonService(pdao);
		Person retrievedPatient = ps.getPatientInfo(patientId);
		assertEquals(testPatient, retrievedPatient);
	}
	
	@Test
	public void testGetPrescriptionInfo() {
		// fail("Not yet implemented");
	}
	
	@Test
	public void testUpdatePatientInfoSuccess() {
		Mockito.when(pdao.updatePatientInfo(testPatient)).thenReturn(true);
		
		ps = new PersonService(pdao);
		boolean success = ps.updatePatientInfo(testPatient);
		assertEquals(true, success);
	}
	
	@Test
	public void testUpdatePatientInfoFail() {
		// fail("Not yet implemented");
	}
}
