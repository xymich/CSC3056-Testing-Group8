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
 
	/* in lab notes
	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0",
					0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	*/
	
	// getLowerBound() tests
	@Test
	public void testLowerBoundValueShouldBeNeg1() {
		assertEquals("The lower bound value of -1 and 1 should be -1",
				-1, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testLowerBoundValueShouldNotBePos1() {
		assertNotEquals("The lower bound value of -1 and 1 should not be 1",
				1, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testLowerBoundValueShouldNotBeNeg2() {
		assertNotEquals("The lower bound value of -1 and 1 should not be -2",
				-2, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	
	// getUpperBound() tests
	@Test
	public void testUpperBoundValueShouldBePos1() {
		assertEquals("The upper bound value of -1 and 1 should be 1", 
				1, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testUpperBoundValueShouldNotBeNeg1() {
		assertNotEquals("The upper bound value of -1 and 1 should not be -1", 
				-1, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testUpperBoundValueShouldNotBePos2() {
		assertNotEquals("The upper bound value of -1 and 1 should not be 2", 
				2, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}
	
	// equals() tests
	@Test 
	public void testEqualsSameObjSameRange() { 
		assertEquals("The two objects compared are identical thus should return true",
				true, rangeObjectUnderTest.equals(rangeObjectUnderTest)); 
	}
	
	@Test 
	public void testEqualsDifferentObjSameRange() { 
		Range rangeObjectToCompare = new Range(-1, 1);
		assertEquals("The two objects compared are same range thus should return true",
				true, rangeObjectUnderTest.equals(rangeObjectToCompare)); 
	}
	
	@Test 
	public void testEqualsDifferentObjDifferentRange() { 
		Range rangeObjectToCompare = new Range(-2, 2);
		assertEquals("The two objects compared are same range thus should return true",
				false, rangeObjectUnderTest.equals(rangeObjectToCompare)); 
	}
	
	@Test
	public void testEqualsNullObj() { 
		Range rangeObjectToCompare = null;
		assertEquals("The two objects compared are same range thus should return true",
				false, rangeObjectUnderTest.equals(rangeObjectToCompare)); 
	}
	
	@Test
	public void test() {
		
	}
	
	// expandToInclude() tests
	@Test 
	public void testExpandToIncludeWithinRange() { 
		//Range expectedExpandedRange = new Range(-1, 1); // now using rangeObjectUnderTest
		double testValue = 0.99;
		Range actualExpandedRange = Range.expandToInclude(rangeObjectUnderTest, testValue);
		double actualUpperValue = actualExpandedRange.getUpperBound();
		System.out.println("is in" + actualExpandedRange);
		
		assertEquals("The upper bound value should be adjusted/expand to fit 0.99 into the "
				+ "range -1, 1 even if its in bounds already",
				testValue, actualUpperValue, 0.000000001d); 
	}	
	@Test 
	public void testExpandToIncludeOutsideRange() { 
		double testValue = -2;
		Range actualExpandedRange = Range.expandToInclude(rangeObjectUnderTest, testValue);
		System.out.println("not in" + actualExpandedRange);
		
		assertEquals("The two objects compared once expanded should be different as value is outside the range.",
				false, actualExpandedRange.equals(rangeObjectUnderTest)); 
	}	
	 


}
