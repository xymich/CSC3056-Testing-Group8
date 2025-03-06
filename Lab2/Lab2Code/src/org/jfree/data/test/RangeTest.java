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
	
	// expandToInclude() tests
	@Test 
	public void testExpandToIncludeWithinRangePositive() { 
		Range expectedExpandedRange = new Range(-1, 1);
		double testValue = 0.50;
		Range actualExpandedRange = Range.expandToInclude(rangeObjectUnderTest, testValue);
		
		assertEquals("The range should not be adjusted/expanded and should include original range",
				true, actualExpandedRange.equals(expectedExpandedRange)); 
	}	
	
	@Test 
	public void testExpandToIncludeWithinRangeNegative() { 
		Range expectedExpandedRange = new Range(-1, 1); 
		double testValue = -0.50;
		Range actualExpandedRange = Range.expandToInclude(rangeObjectUnderTest, testValue);
		
		assertEquals("The range should not be adjusted/expanded and should include original range",
				true, actualExpandedRange.equals(expectedExpandedRange)); 
	}	
	
	@Test 
	public void testExpandToIncludeOnRangePositive() { 
		Range expectedExpandedRange = new Range(-1, 1);
		double testValue = 1;
		Range actualExpandedRange = Range.expandToInclude(rangeObjectUnderTest, testValue);
		
		assertEquals("The range should not be adjusted/expanded and should include original range",
				true, actualExpandedRange.equals(expectedExpandedRange)); 
	}	
	
	@Test 
	public void testExpandToIncludeOnRangeNegative() { 
		Range expectedExpandedRange = new Range(-1, 1);
		double testValue = -1;
		Range actualExpandedRange = Range.expandToInclude(rangeObjectUnderTest, testValue);
		
		assertEquals("The range should not be adjusted/expanded and should include original range",
				true, actualExpandedRange.equals(expectedExpandedRange)); 
	}	
	
	@Test 
	public void testExpandToIncludeOutsideRangePositive() { 
		Range expectedExpandedRange = new Range(-1, 10);
		double testValue = 10;
		Range actualExpandedRange = Range.expandToInclude(rangeObjectUnderTest, testValue);
		
		assertEquals("The upper bound value should be adjusted/expanded and should include original range keeping same lowerbound",
				true, actualExpandedRange.equals(expectedExpandedRange)); 
	}	
	 
	@Test 
	public void testExpandToIncludeOutsideRangeNegative() { 
		Range expectedExpandedRange = new Range(-10, 1);
		double testValue = -10;
		Range actualExpandedRange = Range.expandToInclude(rangeObjectUnderTest, testValue);
		
		assertEquals("The lower bound value should be adjusted/expanded and should include original range keeping same upperbound",
				true, actualExpandedRange.equals(expectedExpandedRange)); 
	} // method seems to only change values randomly and does not keep inputted range, but changes it
	 


}
