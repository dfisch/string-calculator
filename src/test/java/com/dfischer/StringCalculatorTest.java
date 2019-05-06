package com.dfischer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @Before
    public void setup() {
        this.calculator = new StringCalculator();
    }

    @Test
    public void singleNumberStringReturnsNumber() {
        assertEquals(1, calculator.add("1"));
        assertEquals(42, calculator.add("42"));
    }

    @Test
    public void multipleCommaDelimitedNumbersInStringReturnsSum() {
        assertEquals(2, calculator.add("1,1"));
        assertEquals(5, calculator.add("2,3"));
        assertEquals(5, calculator.add("1,2,1,1"));
        assertEquals(10, calculator.add("2,3,1,1,1,1,1"));
    }

    @Test
    public void multipleNewLineDelimitedNumbersInStringReturnsSum() {
        assertEquals(2, calculator.add("1/n1"));
        assertEquals(5, calculator.add("2/n3"));
        assertEquals(5, calculator.add("1/n2/n1/n1"));
        assertEquals(10, calculator.add("2/n3/n1/n1/n1/n1/n1"));
    }

    @Test
    public void multipleCustomDelimitedNumbersInStringReturnsSum() {
        assertEquals(2, calculator.add("//;/n1;1"));
        assertEquals(3, calculator.add("//;/n1;2"));
        assertEquals(6, calculator.add("//----/n1----2----3"));
    }

    @Test
    public void negativeNumbersThrowException() {
        try {
            calculator.add("-2,-1,3");
            fail("Negative numbers should throw an exception");
        } catch (Exception e) {
            assertTrue(e.getMessage().toLowerCase().contains("negatives not allowed"));
            assertTrue(e.getMessage().contains("-1"));
            assertTrue(e.getMessage().contains("-2"));
            assertFalse(e.getMessage().contains("3"));
        }
    }

    @Test
    public void numbersBiggerThan1000AreIgnored() {
        assertEquals(3, calculator.add("1,1001,2"));
        assertEquals(1003, calculator.add("1,1000,1001,2"));
    }
}
