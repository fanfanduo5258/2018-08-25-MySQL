package com.junit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest2 {
	public static Calculator c = new Calculator();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAdd() {
		c.add(2);
		c.add(2);
		assertEquals(4, c.getResult());
	}

	@Test
	public void testSubstract() {
		c.substract(2);
		assertEquals(2,c.getResult());
	}

	@Ignore
	public void testMultiply()  {
		c.multiply(10);
	}

	@Test(expected=Exception.class)
	public void testDivide() throws Exception{
		c.divide(0);
	}

	@Test(timeout = 1000)
	public void testSquareRoot() {
		c.squareRoot(9);
	}
}
