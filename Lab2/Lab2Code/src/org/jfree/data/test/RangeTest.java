package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {

	private Range rangeObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0",
					0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
	@Test
	public void testLowerBoundValueShouldBeNeg1() {
		assertEquals("The lower bound value of -1 and 1 should be -1",
				-1, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testUpperBoundValueShouldBePos1() {
		assertEquals("The upper bound value of -1 and 1 should be 1",
				1, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testTemp() {
		assertEquals("",
				2, rangeObjectUnderTest.contains(2));
	}


}
