package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest {

    private Values2D values2D;
    private KeyedValues keyedValues;

    @Before
    public void setUp() {
        // test dataset for column and row total calculations
        DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
        testValues.addValue(5.0, 0, 0);  // Row 0, Column 0
        testValues.addValue(10.0, 1, 0); // Row 1, Column 0
        testValues.addValue(15.0, 2, 0); // Row 2, Column 0
        values2D = testValues;
    }

        //  test data for cumulative percentages
        DefaultKeyedValues kv = new DefaultKeyedValues();
        kv.addValue("A", 10.0);
        kv.addValue("B", 20.0);
        kv.addValue("C", 30.0);
        keyedValues = kv;
    }

    @After
    public void tearDown() {
        values2D = null;
        keyedValues = null;
<<<<<<< HEAD
        
    }
=======
    }

    @Test
    public void testCalculateColumnTotalValid() {
        double actual = DataUtilities.calculateColumnTotal(values2D, 0);
        assertEquals(30.0, actual, 0.0001);  // expeected - 5 + 10 + 15 = 30
    }

    @Test
    public void testCalculateRowTotalValid() {
        double actual = DataUtilities.calculateRowTotal(values2D, 1);
        assertEquals(10.0, actual, 0.0001); // expected- 10 (ONLY ONE VALUE IN ROW1!!)
    }

    @Test
    public void testCreateNumberArrayValid() {
        double[] input = {1.1, 2.2, 3.3};
        Number[] result = DataUtilities.createNumberArray(input);
        assertEquals(3, result.length);
        assertEquals(1.1, result[0].doubleValue(), 0.0001);
        assertEquals(2.2, result[1].doubleValue(), 0.0001);
        assertEquals(3.3, result[2].doubleValue(), 0.0001);
    }

    @Test
    public void testCreateNumberArray2DValid() {
        double[][] input = {{1.1, 2.2}, {3.3, 4.4}};
        Number[][] result = DataUtilities.createNumberArray2D(input);
        assertEquals(2, result.length);
        assertEquals(2, result[0].length);
        assertEquals(1.1, result[0][0].doubleValue(), 0.0001);
    }

    @Test
    public void testGetCumulativePercentagesValid() {
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        assertEquals(0.1667, result.getValue("A").doubleValue(), 0.0001);
        assertEquals(0.5, result.getValue("B").doubleValue(), 0.0001);
        assertEquals(1.0, result.getValue("C").doubleValue(), 0.0001);
    }
}
>>>>>>> aa526449239c98c9aa813efbee578a92b0f6914b
