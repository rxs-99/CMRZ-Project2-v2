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

import com.revature.dao.MedicationDAO;
import com.revature.model.Medication;

public class MedicationServiceTest 
{
	@InjectMocks
	private static MedicationService medicationService;
	
	@Mock
	private MedicationDAO md;

	public static List<Medication> testMedications = new ArrayList<>(Arrays.asList(
			new Medication(1, "Alprazolam", "Xanax", 0),
			new Medication(2, "Oxycodone", "Oxaydo", 10),
			new Medication(3, "Ibuprofen", "Advil", 7)
		));

	@Before
	public void before() 
	{
		MockitoAnnotations.openMocks(this);
	}
	
	
	@Test
	public void testGetAll()
	{
		Mockito.when(md.getAll()).thenReturn(testMedications);
		
		List<Medication> l = medicationService.getAll();
		
		Assert.assertEquals("Xanax", l.get(0).getSupplier());
		Assert.assertEquals("Oxaydo", l.get(1).getSupplier());
		Assert.assertEquals("Advil", l.get(2).getSupplier());
	}
	
	
	@Test
	public void testGetAllAvailableMedications()
	{
		Mockito.when(md.getAll()).thenReturn(testMedications);
		
		List<Medication> l = medicationService.getAllAvailableMedications();
		
		Assert.assertEquals("Oxaydo", l.get(0).getSupplier());
		Assert.assertEquals("Advil", l.get(1).getSupplier());
		Assert.assertEquals(2, l.size());
	}

}
