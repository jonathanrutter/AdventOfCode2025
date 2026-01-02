package com.wuppski.advent05;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class IngredientsInventory {

    private List<Range> freshRangesList;
    private List<Long> ingredientsSelected;
    private List<Range> mergedRanges;

    public void parse(String multilineInput) {
        List<String> input = Arrays.stream(multilineInput.split("\n"))
                .map(String::trim)
                .toList();
        parse(input);
    }

    public void parse(List<String> input) {
        boolean emptyLineFound = false;
        freshRangesList = new ArrayList<>();
        ingredientsSelected = new ArrayList<>();

        for (String str : input)
        {
            if (str.isEmpty()) {
                emptyLineFound = true;
            } else if (!emptyLineFound) {
                freshRangesList.add(new Range(str));
            } else {
                ingredientsSelected.add(Long.parseLong(str));
            }
        };
    }

    public long getFreshIngredientsTotal() {

         return ingredientsSelected
                .stream()
                .filter(ingredientsIndex ->
                    freshRangesList.stream().anyMatch(range -> range.containsValue(ingredientsIndex))
                )
                .count();
    }

    /**
     * Does not merge the ranges and builds a set of Longs
     * so can cause in memory issues for large datasets
     * @deprecated has memory problems with large data sets
     */
    public Set<Long> getALlFreshIngredientIdsWithMemoryIssues()
    {
        Set<Long> allFreshIds = new HashSet<>();
        freshRangesList.forEach(range -> {
            System.out.printf("Range min %d max %d total %d%n", range.minValue(), range.maxValue(), (range.maxValue() - range.minValue() + 1));
            Set<Long> freshIngredientSet = LongStream.range(range.minValue(), range.maxValue() +1)
                    .boxed()
                    .collect(Collectors.toSet());
            allFreshIds.addAll(freshIngredientSet);
        });
        return allFreshIds;
    }

    public long getALlFreshIngredientIds()
    {
        mergeRanges();
        return mergedRanges
                .stream()
                .mapToLong(range -> range.maxValue() - range.minValue() + 1)
                .sum();
    }

    private void mergeRanges() {
        mergedRanges = new ArrayList<>();

        freshRangesList.forEach(this::mergeRange);
    }

    private void mergeRange(Range rawRange)
    {
        if (mergedRanges.isEmpty()) {
            mergedRanges.add(rawRange);
        }
        else {
            boolean merged = false;
            for (Range originalRange : mergedRanges) {
                Range mergedRange = originalRange.merge(rawRange);
                if (mergedRange != null) {
                    merged = true;
                    mergedRanges.remove(originalRange);
                    //The newly created Range might also merge with another existing range
                    // so call the method again
                    mergeRange(mergedRange);
                    break;
                }
            }

            if (!merged) {
                mergedRanges.add(rawRange);
            }
        }
    }

}
