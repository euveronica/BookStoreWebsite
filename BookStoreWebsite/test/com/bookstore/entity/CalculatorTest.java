package com.bookstore.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		//GIVEN
		Calculator calculator = new Calculator();
		//WHEN
		int a= 1234;
		int b = 5678;
		int result = calculator.add(a, b);
		
		int expected = 6912;
		//THEN
		assertEquals(expected, result);
	}
	@Test
	public void testAddA() {
		//GIVEN
		Calculator calculator = new Calculator();
		//WHEN
		int a= 1234;
		int b = 5678;
		int result = calculator.add(a, b);
		
		int expected = 692;
		//THEN
		assertEquals(expected, result);
	}

}
