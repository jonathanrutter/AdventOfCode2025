package com.wuppski.advent01;

import java.util.List;

public class ZeroCounter {
    public static final int STARTING_POSITION = 50;
    public static final int DIAL_SIZE = 100;

    private final boolean includePassingZero;

    public int getZeroCount() {
        return zeroCount;
    }

    public int getPosition() {
        return position;
    }

    private int zeroCount = 0;
    private int position;

    public ZeroCounter(boolean includePassingZero) {
        this.includePassingZero = includePassingZero;
        position = STARTING_POSITION;
    }

    public void calculateCount(List<String> inputLines)
    {
        for ( String line : inputLines ) {
            int rotation = getRotationValue(line);
            singleLineCalc(rotation);
//            System.out.printf("T1 Read line %s, position %d, zeroCount %d%n", line, position, zeroCount);
        }
    }

    protected void singleLineCalc(int rotation ) {
        int newPosition = position + rotation;

        if (includePassingZero) {
            int zerosPassed = calculateZerosPassed(newPosition, rotation);
            zeroCount += zerosPassed;
        }
        else if (newPosition % DIAL_SIZE == 0) {
            zeroCount++;
        }

        position = Math.floorMod(newPosition, DIAL_SIZE);
    }

    protected static int calculateZerosPassed(int newPosition, int rotation) {
        int zerosPassed;
        if (rotation > 0) {
            zerosPassed = newPosition / DIAL_SIZE;
        }
        else {
            zerosPassed = (DIAL_SIZE - newPosition) / DIAL_SIZE;
            boolean startedAtZero = newPosition - rotation == 0;
            if (startedAtZero) {
                zerosPassed--;
            }
        }
        return zerosPassed;
    }

    public int getRotationValue(String line) {
        char direction = line.charAt(0);
        int val = Integer.parseInt( line.substring(1) );
        return (direction == 'R') ? val : val *-1;
    }

}
