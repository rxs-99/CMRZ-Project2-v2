package com.revature.model;

import org.junit.Assert;
import org.junit.Test;

public class PrescriptionTest {
	
	@Test
	public void testPrescription() {
		Prescription p = new Prescription(2,new Medication(1,"t","e",42),new Person(),new Person(), 12);
		
		Assert.assertEquals(2, p.getId());
		Assert.assertEquals(12, p.getDosage(),2);
		Assert.assertEquals("e", p.getMedication().getSupplier());
		Assert.assertNull(p.getPatient().getName());
	}
}
