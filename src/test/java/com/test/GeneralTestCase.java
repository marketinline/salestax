package com.test;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GeneralTestCase
{

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testBigDecimalNegate()
	{
		BigDecimal operand = new BigDecimal("10");
		BigDecimal augend = new BigDecimal("5");
		System.out.println(operand.add(augend.negate()));
	}
	
	@Test
	public void testBigDecimalCompareTo()
	{
		BigDecimal operand = new BigDecimal("10");
		BigDecimal augend = new BigDecimal("5");
		System.out.println(operand.compareTo(augend));
	}

}
