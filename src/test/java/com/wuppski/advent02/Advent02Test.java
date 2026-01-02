package com.wuppski.advent02;

import org.junit.Assert;
import org.junit.Test;

public class Advent02Test {

    @Test
    public void part1Test() {
        String[] tokens = Advent02.getInput().split(",");
        long total = Advent02.getInvalidTotal(tokens, 2);
        Assert.assertEquals(40398804950L, total);
    }

    @Test
    public void part2Test() {
        String[] tokens = Advent02.getInput().split(",");
        long total = Advent02.getInvalidTotal(tokens, Integer.MAX_VALUE);
        Assert.assertEquals(65794984339L, total);
    }

    @Test
    public void exampleInputTest() {
        String[] tokens = Advent02.getTestInput().split(",");
        long total = Advent02.getInvalidTotal(tokens, 2);
        Assert.assertEquals(1227775554L, total);
    }

    @Test
    public void getInvalidSumTest() {
        Range range = new Range("98-112");
        Assert.assertEquals(99, range.getInvalidSum(2));
    }

    @Test
    public void getInvalidSumTest3Reps() {
        Range range = new Range("98-112");
        Assert.assertEquals(210, range.getInvalidSum(3));
    }

    @Test
    public void invalidIntTest() {
        Range range = new Range("98-112");
        Assert.assertFalse(range.isInvalidLong(100, 2));
        Assert.assertTrue(range.isInvalidLong(99, 2));
        Assert.assertTrue(range.isInvalidLong(111, 3));
    }
}
