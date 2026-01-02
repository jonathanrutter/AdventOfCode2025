package com.wuppski.advent03;

import java.util.List;

public class BatteryBankArray {
    List<BatteryBank> batteryBankLists;
    public BatteryBankArray (List<String> inputs) {
        batteryBankLists = inputs
                            .stream()
                            .map(BatteryBank::new)
                            .toList();
    }

    public long getTotalJolts(int numberOfBatteriesPerBank) {
        return batteryBankLists
                    .stream()
                    .mapToLong(batteryBank -> batteryBank.getMaximumOutput(numberOfBatteriesPerBank))
                    .sum();
    }
}
