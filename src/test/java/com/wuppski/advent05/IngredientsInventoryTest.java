package com.wuppski.advent05;

import com.wuppski.FileReader;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class IngredientsInventoryTest {

    private static final String TEST_INGREDIENTS_RANGES =
            """
                    3-5
                    10-14
                    16-20
                    12-18
                    
                    1
                    5
                    8
                    11
                    17
                    32
                    """;

    private static final String TEST_INGREDIENTS_RANGES_2 =
            """
                    100-105
                    110-119
                    103-124
                    
                    1
                    5
                    8
                    11
                    17
                    32
                    """;

    @Test
    public void smallInputTest() {
        IngredientsInventory ii = new IngredientsInventory();
        ii.parse(TEST_INGREDIENTS_RANGES);
        Assert.assertEquals(3, ii.getFreshIngredientsTotal());
    }

    @Test
    public void fullInputTest() {
        IngredientsInventory ii = new IngredientsInventory();
        ii.parse(FileReader.readFile("/05-input.txt"));
        Assert.assertEquals(848, ii.getFreshIngredientsTotal());
    }

    @Test
    public void getSmallTotalFreshIdsWithMemoryIssuesTest() {
        IngredientsInventory ii = new IngredientsInventory();
        ii.parse(TEST_INGREDIENTS_RANGES);
        Assert.assertEquals(14, ii.getALlFreshIngredientIdsWithMemoryIssues().size());
    }

    @Test
    public void getSmallTotalFreshIdsTest() {
        IngredientsInventory ii = new IngredientsInventory();
        ii.parse(TEST_INGREDIENTS_RANGES);
        Assert.assertEquals(14, ii.getALlFreshIngredientIds());
    }

    @Test
    public void getSmallTotalFreshIdsTest2() {
        IngredientsInventory ii = new IngredientsInventory();
        ii.parse(TEST_INGREDIENTS_RANGES_2);
        Assert.assertEquals(25, ii.getALlFreshIngredientIds());
    }

    @Test
    public void getFullTotalFreshIdsTest() {
        IngredientsInventory ii = new IngredientsInventory();
        ii.parse(FileReader.readFile("/05-input.txt"));
        Assert.assertEquals(334714395325710L, ii.getALlFreshIngredientIds());
    }
}
