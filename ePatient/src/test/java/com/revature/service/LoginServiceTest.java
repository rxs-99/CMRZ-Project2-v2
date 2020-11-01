package com.revature.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LoginServiceTest {

	@Test
	public void testLogin() {
		LoginService l = new LoginService();
		
		assertEquals(l.login("user", "password"), 1);
		assertEquals(l.login("user", "password1"), -1);
		assertEquals(l.login("gjhsfgjh", "password"), -1);
		
	}
	
}
