package com.revature.model;

import org.junit.Assert;
import org.junit.Test;

public class PositionTest {
	
	@Test
	public void testPosition() {
		Position p = new Position(3,"aklhdj");
		
		Assert.assertEquals(3, p.getId());
		Assert.assertEquals("aklhdj", p.getName());
	}
}
