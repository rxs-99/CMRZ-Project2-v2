package com.revature.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.dao.PrescriptionDAO;
import com.revature.model.Person;
import com.revature.model.Prescription;

public class PrescriptionServiceTest 
{
	@InjectMocks
	private static PrescriptionService prescriptionService;
	
	@Mock
	private PrescriptionDAO pd;
	
	public static Person anotherPatient = new Person(
			3,
			"Another Test Patient",
			"555-555-5555",
			"patient@email.com",
			null
		);
	
	
	public static Person anotherDoctor = new Person(
			4,
			"Another Test Doctor",
			"555-555-5555",
			"Doctor4@email.com",
			null
		);

	private static List<Prescription> testPrescriptions = new ArrayList<>(Arrays.asList(
			new Prescription(1, MedicationServiceTest.testMedications.get(0), PersonServiceTest.testPerson, PersonServiceTest.testDoctor, 3),
			new Prescription(2, MedicationServiceTest.testMedications.get(1), anotherPatient, PersonServiceTest.testDoctor, 6.23),
			new Prescription(3, MedicationServiceTest.testMedications.get(2), anotherPatient, anotherDoctor, 4)
			
		));

	@Before
	public void before() 
	{
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testGetAll()
	{
		Mockito.when(pd.getAll()).thenReturn(testPrescriptions);
		
		List<Prescription> l = prescriptionService.getAll();
		
		Assert.assertEquals(1, l.get(0).getId());
		Assert.assertEquals(2, l.get(1).getId());
		Assert.assertEquals(3, l.get(2).getId());
	}
	
	@Test
	public void testGetPrescriptionsByDoctor()
	{
		Mockito.when(pd.getAll()).thenReturn(testPrescriptions);
		
		List<Prescription> l = prescriptionService.getPrescriptionsByDoctor(PersonServiceTest.testDoctor);
		
		Assert.assertEquals(PersonServiceTest.testDoctor, l.get(0).getDoctor());
		Assert.assertEquals(PersonServiceTest.testDoctor, l.get(1).getDoctor());
		Assert.assertEquals(2, l.size());
	}
	
	@Test
	public void testGetPrescriptionsByPatient()
	{
		Mockito.when(pd.getAll()).thenReturn(testPrescriptions);
		
		List<Prescription> l = prescriptionService.getPrescriptionsByPatient(anotherPatient);
		
		Assert.assertEquals(anotherPatient, l.get(0).getPatient());
		Assert.assertEquals(anotherPatient, l.get(1).getPatient());
		Assert.assertEquals(2, l.size());
	}
	
	
	@Test
	public void testGetPrescriptionsByMedication()
	{
		Mockito.when(pd.getAll()).thenReturn(testPrescriptions);
		
		List<Prescription> l = prescriptionService.getPrescriptionsByMedication(MedicationServiceTest.testMedications.get(1));
		
		Assert.assertEquals(MedicationServiceTest.testMedications.get(1), l.get(0).getMedication());
		Assert.assertEquals(1, l.size());
	}	
}