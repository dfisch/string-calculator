package com.dfischer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
