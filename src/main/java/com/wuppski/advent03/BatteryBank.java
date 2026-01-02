package com.wuppski.advent03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BatteryBank {
    private final List<Integer> batteryValues;
    public BatteryBank(String bankString) {
        batteryValues = bankString
                .chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();
    }

    /**
     * The highest value is the highest int that isn't the last element
     * @return highest int that can be made from two values in the List, the values must be in order
     */
    public long getMaximumOutput(int numberOfBatteriesPerBank)
    {
        long maxJoltage = 0;
        int firstIndex = 0;

        for(int i = 1; i <= numberOfBatteriesPerBank; i++)
        {
            int lastIndex = batteryValues.size() -numberOfBatteriesPerBank +i;
            List<Integer> sublist = batteryValues.subList(firstIndex, lastIndex);

            // find the highest values that is not too close to the end
            int max = Collections.max(sublist);
            maxJoltage += (long) (max * Math.pow(10, numberOfBatteriesPerBank-i));

            // find the first index for the next battery
            firstIndex += sublist.indexOf(max) +1;
        }
        return maxJoltage;
    }
}

