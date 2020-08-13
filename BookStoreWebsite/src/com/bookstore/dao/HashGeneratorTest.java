package com.bookstore.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashGeneratorTest {

	@Test
	public void testGenerateMD5() {
		String password = "secret26";
		String encryptedPassword = HashGenerator.generateMD5(password);
		
		System.out.println(encryptedPassword);
		
		assertTrue(true);
	}

}
