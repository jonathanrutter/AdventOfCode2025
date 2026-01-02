package com.wuppski.advent02;

import com.wuppski.FileReader;

import java.util.Arrays;

public class Advent02 {

    public static long getInvalidTotal(String[] tokens, int maxRepetitions) {

        return Arrays
                .stream(tokens)
                .map(Range::new)
                .mapToLong(range -> range.getInvalidSum(maxRepetitions))
                .sum();
    }

    public static String getTestInput() {
        return """
                11-22,95-115,998-1012,1188511880-1188511890,222220-222224,
                1698522-1698528,446443-446449,38593856-38593862,565653-565659,
                824824821-824824827,2121212118-2121212124
                """;
    }

    public static String getInput() {
        return FileReader.readFile("/02-input.txt").getFirst();
    }

}
