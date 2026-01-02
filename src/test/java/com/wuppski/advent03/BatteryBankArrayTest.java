package com.wuppski.advent03;

import com.wuppski.FileReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BatteryBankArrayTest {
    private final String testInput = """
                            987654321111111
                            811111111111119
                            234234234234278
                            818181911112111
            """;

    @Test
    public void calculateTestInput() {
        List<String> inputData = Arrays.asList(testInput.strip().split("\\s+"));
        BatteryBankArray bba = new BatteryBankArray(inputData);
        Assert.assertEquals(357, bba.getTotalJolts(2));
    }

    @Test
    public void calculateTestInput12Batteries() {
        List<String> inputData = Arrays.asList(testInput.strip().split("\\s+"));
        BatteryBankArray bba = new BatteryBankArray(inputData);
        Assert.assertEquals(3121910778619L, bba.getTotalJolts(12));
    }

    @Test
    public void calculateFileInput() {
        List<String> inputData = FileReader.readFile("/03-input.txt");
        BatteryBankArray bba = new BatteryBankArray(inputData);
        Assert.assertEquals(17613, bba.getTotalJolts(2));
    }

    @Test
    public void calculateFileInput12Baterries() {
        List<String> inputData = FileReader.readFile("/03-input.txt");
        BatteryBankArray bba = new BatteryBankArray(inputData);
        Assert.assertEquals(175304218462560L, bba.getTotalJolts(12));
    }
}
