package com.revature.model;

import org.junit.Assert;
import org.junit.Test;

public class LoginEntryTest {

	@Test
	public void testLoginEntry() {
		LoginEntry le = new LoginEntry(new Person(), "username", "pass234");
		
		Assert.assertEquals("username", le.getUsername());
		Assert.assertEquals("pass234", le.getPassword());
	}
}
