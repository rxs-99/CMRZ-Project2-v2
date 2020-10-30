package com.revature.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginServiceTest {

	@Test
	public void testLogin() {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		LoginService l = ctx.getBean("loginService", LoginService.class);
		
		assertEquals(l.login("user", "password"), 1);
		assertEquals(l.login("user", "password1"), -1);
		assertEquals(l.login("gjhsfgjh", "password"), -1);
		((ConfigurableApplicationContext) ctx).close();
		
	}
	
}
