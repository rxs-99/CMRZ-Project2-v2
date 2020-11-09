package com.revature.model;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
	
	@Test
	public void testPerson() {
		Person p = new Person(1,"t","e","s",new Position(2,"t"));
		Assert.assertEquals(1, p.getId());
		Assert.assertEquals("t", p.getPosition().getName());
		Assert.assertEquals("s", p.getEmail());
	}
}
