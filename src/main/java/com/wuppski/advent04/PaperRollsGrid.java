package com.wuppski.advent04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaperRollsGrid {
    protected static final int MAX_ALLOWED_ADJACENT_ROLLS = 3;

    private List<List<Boolean>> rollLocations;

    public PaperRollsGrid(List<String> input) {
        rollLocations = input
                .stream()
                .map(this::parseRow)
                .toList();
    }

    public List<Boolean> parseRow(String rowData) {
        return Arrays
                .stream(rowData.split(""))
                .map(myChar -> myChar.equals("@"))
                .toList();
    }

    public int getTotalAccessibleRolls(boolean repeatUntilMaxCollected) {
        int totalAccessible = 0;
        int currentlyAccessible;
        do {
            currentlyAccessible = getAccessibleRolls();
            totalAccessible += currentlyAccessible;
        }
        while (repeatUntilMaxCollected && currentlyAccessible > 0);

        return totalAccessible;
    }

    protected List<List<Boolean>> getCopyOfRollsList() {
        List<List<Boolean>> copyList = new ArrayList<List<Boolean>>(rollLocations.size());
        for (List<Boolean> roll : rollLocations)
        {
            copyList.add(new ArrayList<Boolean>(roll));
        }
        return copyList;
    }

    protected int getAccessibleRolls() {
        int count = 0;
        List<List<Boolean>> newRollLocations = getCopyOfRollsList();

        for (int i = 0; i < rollLocations.size(); i++ ) {
            for (int j = 0; j < rollLocations.getFirst().size(); j++ ) {
                boolean isRollAtLocation = rollLocations.get(i).get(j);

                if (isRollAtLocation) {
                    List<Boolean> previousRow = (i > 0) ? rollLocations.get(i - 1) : null;
                    List<Boolean> nextRow = (i < rollLocations.size() - 1) ? rollLocations.get(i + 1) : null;

                    int adjacentRolls = findAdjacentRolls(j, previousRow, true);
                    adjacentRolls += findAdjacentRolls(j, rollLocations.get(i), false);
                    adjacentRolls += findAdjacentRolls(j, nextRow, true);

                    if (adjacentRolls <= MAX_ALLOWED_ADJACENT_ROLLS) {
                        newRollLocations.get(i).set(j, false);
                        count++;
                    }
                }
            }
            System.out.printf("total after %d rows is %d%n", i, count);
        }
        rollLocations = newRollLocations;
        return count;
    }

    protected int findAdjacentRolls(int index, List<Boolean> row, boolean includeMiddleValue) {
        int count = 0;
        if (row != null) {
            if (index > 0 && row.get(index - 1)) {
                count ++;
            }
            if (includeMiddleValue && row.get(index)) {
                count ++;
            }
            if (index < (row.size() -1) && row.get(index + 1)) {
                count ++;
            }
        }
        return count;
    }

}
