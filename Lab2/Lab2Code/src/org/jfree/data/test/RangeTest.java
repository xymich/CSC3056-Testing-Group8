package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {

	// prerequisites  ------------------------------------
	
	private Range rangeObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-6, 6);
	}

	@After
	public void tearDown() throws Exception {
		rangeObjectUnderTest = null;
	}
 
	/* in lab notes
	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0",
					0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	*/
	
	// getLowerBound() tests ------------------------------------
	@Test
	public void testLowerBoundValueShouldBeNegative() {
		assertEquals("The lower bound value of -6 and 6 should be -6",
				-6, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testLowerBoundValueShouldNotBeInnerPositive() {
		assertNotEquals("The lower bound value of -6 and 6 should not be 6",
				6, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testLowerBoundValueShouldNotBeOuterNegative() {
		assertNotEquals("The lower bound value of -6 and 6 should not be outside at -10",
				-10, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	
	// getUpperBound() tests ------------------------------------
	@Test
	public void testUpperBoundValueShouldBePos1() {
		assertEquals("The upper bound value of -1 and 1 should be 1", 
				6, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testUpperBoundValueShouldNotBeNeg1() {
		assertNotEquals("The upper bound value of -1 and 1 should not be -6", 
				-6, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testUpperBoundValueShouldNotBePos2() {
		assertNotEquals("The upper bound value of -1 and 1 should not be outside at 10", 
				10, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}
	
	// equals() tests ------------------------------------
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
	
	// expandToInclude() tests ------------------------------------
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
		double testValue = -0.88;
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
	 
	// expand() tests
	@Test 
	public void testExpandRangeBoth50Percent() { 
		Range expectedExpandedRange = new Range(1, 8);
		Range testRange = new Range(2, 6);
		double testLowerPercent = 0.25;
		double testUpperPercent = 0.50;
		Range actualExpandedRange = Range.expand(testRange, testLowerPercent, testUpperPercent);
		
		System.out.println("100" + actualExpandedRange + expectedExpandedRange);
		
		assertEquals("The range should be adjusted/expanded by double on each lower and upper and should include original range",
				true, actualExpandedRange.equals(expectedExpandedRange)); 
	}	
	
	@Test 
	public void testExpandRangeLower0Percent() { 
		Range expectedExpandedRange = new Range(-1, 2);
		double testLowerPercent = 0.00;
		double testUpperPercent = 0.50;
		Range actualExpandedRange = Range.expand(rangeObjectUnderTest, testLowerPercent, testUpperPercent);
		
		System.out.println("0" + actualExpandedRange);
		
		assertEquals("The range should be adjusted/expanded by double on each lower and upper and should include original range",
				true, actualExpandedRange.equals(expectedExpandedRange)); 
	}	


}
