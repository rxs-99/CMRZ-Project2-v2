package com.revature.model;

import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;

public class TestAppointment {
	@Test
	public void testAppointment() {
		Appointment a = new Appointment(1, new Person(), new Person(), new Date(2135465), "lol", "help");
		Assert.assertEquals(1, a.getId());
		Assert.assertEquals("lol", a.getComment());
		Assert.assertEquals("help", a.getStatus());
		Assert.assertNull(a.getDoctor().getName());
	}
}
