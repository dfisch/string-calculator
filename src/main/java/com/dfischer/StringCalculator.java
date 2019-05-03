package com.dfischer;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    private int splitAndSumNumbersOnDelimiter(String numbers, String delim) {
        this.validate(numbers, delim);

        return Pattern.compile(delim)
            .splitAsStream(numbers)
            .mapToInt(Integer::parseInt)
            .sum();
    }

    private void validate(String numbers, String delim) {
        List<Integer> negativeNumbers = Pattern.compile(delim)
            .splitAsStream(numbers)
            .mapToInt(Integer::parseInt)
            .filter(value -> value < 0)
            .boxed()
            .collect(Collectors.toList());

        if (negativeNumbers.size() > 0) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers.toString());
        }
    }
}
