package com.dfischer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void singleNumberStringReturnsNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
        assertEquals(42, calculator.add("42"));
    }

    @Test
    public void twoCommaDelimitedNumbersInStringReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(2, calculator.add("1,1"));
        assertEquals(5, calculator.add("2,3"));
    }
}
