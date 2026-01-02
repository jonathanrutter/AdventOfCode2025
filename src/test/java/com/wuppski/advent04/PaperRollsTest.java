package com.wuppski.advent04;

import com.wuppski.FileReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PaperRollsTest {

    private static final String testInput = """
            ..@@.@@@@.
            @@@.@.@.@@
            @@@@@.@.@@
            @.@@@@..@.
            @@.@@@@.@@
            .@@@@@@@.@
            .@.@.@.@@@
            @.@@@.@@@@
            .@@@@@@@@.
            @.@.@@@.@.
            """;

    @Test
    public void rowTest() {
        List<Boolean> row = List.of(false, false, true, true, true, false, true, false);
        List<String> inputData = Arrays.asList(testInput.strip().split("\\s+"));
        PaperRollsGrid prg = new PaperRollsGrid(inputData);
        Assert.assertEquals(2, prg.findAdjacentRolls(4, row, true));
        Assert.assertEquals(1, prg.findAdjacentRolls(4, row, false));
    }

    @Test
    public void noRepeatSmallInputTest() {
        List<String> inputData = Arrays.asList(testInput.strip().split("\\s+"));
        PaperRollsGrid prg = new PaperRollsGrid(inputData);
        Assert.assertEquals(13, prg.getTotalAccessibleRolls(false));
    }

    @Test
    public void noRepeatLargeInputTest() {
        List<String> inputData = FileReader.readFile("/04-input.txt");
        PaperRollsGrid prg = new PaperRollsGrid(inputData);
        Assert.assertEquals(1384, prg.getTotalAccessibleRolls(false));
    }

    @Test
    public void repeatSmallInputTest() {
        List<String> inputData = Arrays.asList(testInput.strip().split("\\s+"));
        PaperRollsGrid prg = new PaperRollsGrid(inputData);
        Assert.assertEquals(43, prg.getTotalAccessibleRolls(true));
    }

    @Test
    public void repeatLargeInputTest() {
        List<String> inputData = FileReader.readFile("/04-input.txt");
        PaperRollsGrid prg = new PaperRollsGrid(inputData);
        Assert.assertEquals(8013, prg.getTotalAccessibleRolls(true));
    }

}
