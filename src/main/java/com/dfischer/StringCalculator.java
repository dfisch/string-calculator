package com.dfischer;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.matches("[0-9]+")) {
            return Integer.parseInt(numbers);
        }

        if (numbers.contains(",")) {
            String[] parts = numbers.split(",");
            return Integer.parseInt(parts[0]) +
                Integer.parseInt(parts[1]);
        }

        return Integer.MIN_VALUE;
    }
}
