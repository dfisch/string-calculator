package com.dfischer;

import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.matches("[0-9]+")) {
            return Integer.parseInt(numbers);
        }

        if (numbers.contains(",")) {
            return Pattern.compile(",")
                .splitAsStream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
        }

        return Integer.MIN_VALUE;
    }
}
