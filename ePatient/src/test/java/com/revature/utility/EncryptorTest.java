package com.revature.utility;

import org.junit.Assert;
import org.junit.Test;

public class EncryptorTest {
	@Test
	public void testEncrypt() {
		Assert.assertNotEquals("test", Encryptor.encrypt("test"));
		Assert.assertNotEquals("123fah23hg2%$kg2", Encryptor.encrypt("123fah23hg2%$kg2"));
	}
}
