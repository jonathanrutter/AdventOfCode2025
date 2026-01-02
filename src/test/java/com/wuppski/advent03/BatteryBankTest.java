package com.wuppski.advent03;

import org.junit.Assert;
import org.junit.Test;

public class BatteryBankTest
{
    @Test
    public void simpleBatteryBankTest() {
        Assert.assertEquals(65, new BatteryBank("12345654321").getMaximumOutput(2));
        Assert.assertEquals(99, new BatteryBank("987987").getMaximumOutput(2));
        Assert.assertEquals(45, new BatteryBank("12345").getMaximumOutput(2));
        Assert.assertEquals(55, new BatteryBank("512345").getMaximumOutput(2));
    }

    @Test
    public void multipleBatteryBankTest() {
        Assert.assertEquals(6543, new BatteryBank("12345654321").getMaximumOutput(4));
        Assert.assertEquals(9987, new BatteryBank("987987").getMaximumOutput(4));
        Assert.assertEquals(12345, new BatteryBank("12345").getMaximumOutput(5));
        Assert.assertEquals(52345, new BatteryBank("512345").getMaximumOutput(5));
        Assert.assertEquals(987654321111L, new BatteryBank("987654321111111").getMaximumOutput(12));
    }

}
