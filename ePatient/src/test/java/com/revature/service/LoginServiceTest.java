package com.revature.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceTest {

	@Test
	public void testLogin() {
		LoginService l = new LoginService();
		
		Assert.assertNotNull(l.login("user", "password"));
		Assert.assertEquals(l.login("user", "password1"), null);
		Assert.assertEquals(l.login("gjhsfgjh", "password"), null);
		
	}
	
}
