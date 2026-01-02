package com.wuppski.advent02;

public class Range {
    private final long min;

    private final long max;

    public Range(String inputString) {
        String minString = inputString.substring(0, inputString.indexOf('-'));
        min = Long.parseLong(minString.strip());
        String maxString = inputString.substring(inputString.indexOf('-')+1);
        max = Long.parseLong(maxString.strip());
    }

    protected long getInvalidSum(int maxRepetitions) {
        long sum = 0;
        long number = min;
        while (number <= max) {
            if (isInvalidLong(number, maxRepetitions)) {
                sum += number;
            }
            number++;
        }
        return sum;
    }

    protected boolean isInvalidLong(long number, int maxRepetitions) {
        String value = String.valueOf(number);
        boolean invalid = false;

        int valueLength = value.length();
        int minSequenceLength = Math.ceilDiv(valueLength, maxRepetitions);
        int maxSequenceLength = valueLength / 2;

        for (int seqLength = minSequenceLength; !invalid && seqLength <= maxSequenceLength; seqLength++) {
            boolean isMultipleOfSequenceLength = (valueLength % seqLength == 0);
            if (isMultipleOfSequenceLength) {
                invalid = doesLongRepeatPattern(seqLength, value);
            }

        }
        return invalid;
    }

    protected boolean doesLongRepeatPattern(int seqLength, String value) {
        String pattern = value.substring(0, seqLength);
        for (int i = seqLength; i < value.length(); i += seqLength )
        {
            String currentSequence = value.substring(i, i+seqLength);
            if (!currentSequence.equals(pattern)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString()
    {
        return String.format("min: %d, max: %d", min, max);
    }
}
