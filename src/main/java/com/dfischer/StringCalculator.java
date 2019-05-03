package com.dfischer;

import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.matches("[0-9]+")) {
            return Integer.parseInt(numbers);
        }

        if (numbers.contains("//")) {
            String[] parts = numbers.split("/n");
            return this.splitAndSumNumbersOnDelimiter(parts[1], parts[0].substring(2));
        }

        if (numbers.contains(",")) {
            return this.splitAndSumNumbersOnDelimiter(numbers, ",");
        }

        if (numbers.contains("/n")) {
            return this.splitAndSumNumbersOnDelimiter(numbers, "/n");
        }

        return Integer.MIN_VALUE;
    }

    public int splitAndSumNumbersOnDelimiter(String numbers, String delim) {
        return Pattern.compile(delim)
            .splitAsStream(numbers)
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
