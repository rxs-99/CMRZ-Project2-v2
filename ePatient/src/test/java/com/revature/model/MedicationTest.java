package com.revature.model;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class MedicationTest {
	
	@Test
	public void testMedication() {
		Medication m = new Medication(2,"med","tes",69);
		Assert.assertEquals(2, m.getId());
		Assert.assertEquals("med", m.getName());
		Assert.assertEquals(69, m.getAmountStored());
	}
}
