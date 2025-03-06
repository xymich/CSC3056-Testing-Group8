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
        //  test dataset for column and row total calculations
        DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
        testValues.addValue(5.0, 0, 0);  // Row 0, Column 0
        testValues.addValue(10.0, 1, 0); // Row 1, Column 0
        testValues.addValue(15.0, 2, 0); // Row 2, Column 0
        values2D = testValues;

