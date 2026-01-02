package com.wuppski.advent01;

import com.wuppski.FileReader;
import org.junit.Assert;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.List;


public class ZeroCounterTest {

    @Test
    public void testProblem1( ) throws URISyntaxException {
        List<String> inputData = FileReader.readFile("/01-input.txt");

        ZeroCounter zc1 = new ZeroCounter(false);
        zc1.calculateCount(inputData);

        System.out.printf("Count1 is %d%n", zc1.getZeroCount() );
    }

    @Test
    public void testProblem2( ) throws URISyntaxException {
        List<String> inputData = FileReader.readFile("/01-input.txt");
        ZeroCounter zc2 = new ZeroCounter(true);
        zc2.calculateCount(inputData);

        System.out.printf("Count2 is %d%n", zc2.getZeroCount() );
    }

    @Test
    public void testSingleLineCalc() {
        ZeroCounter zc = new ZeroCounter(false);
        zc.singleLineCalc(23 );
        Assert.assertEquals(73, zc.getPosition());
        Assert.assertEquals(0, zc.getZeroCount());

        zc.singleLineCalc(123 );
        Assert.assertEquals(96, zc.getPosition());
        Assert.assertEquals(0, zc.getZeroCount());

        zc.singleLineCalc(-96 );
        Assert.assertEquals(0, zc.getPosition());
        Assert.assertEquals(1, zc.getZeroCount());
    }

    @Test
    public void testSingleLineCalcIncludeCrossingZero() {
        ZeroCounter zc = new ZeroCounter(true);
        zc.singleLineCalc(23 );
        Assert.assertEquals(73, zc.getPosition());
        Assert.assertEquals(0, zc.getZeroCount());

        zc.singleLineCalc(123 );
        Assert.assertEquals(96, zc.getPosition());
        Assert.assertEquals(1, zc.getZeroCount());

        zc.singleLineCalc(-96 );
        Assert.assertEquals(0, zc.getPosition());
        Assert.assertEquals(2, zc.getZeroCount());

    }

    @Test
    public void testReadingTestFile() {
        List<String> inputData = FileReader.readFile("/01-input.txt");
        ZeroCounter zc = new ZeroCounter(false);
        zc.calculateCount(inputData);
        Assert.assertEquals(1152, zc.getZeroCount());
    }

    @Test
    public void testReadingTestFileIncCrossings() {
        List<String> inputData = FileReader.readFile("/01-input.txt");
        ZeroCounter zc = new ZeroCounter(true);
        zc.calculateCount(inputData);
        Assert.assertEquals(6671, zc.getZeroCount());
    }
}
