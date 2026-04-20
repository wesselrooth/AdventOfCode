package com.example.AdventOfCode;

public class GridManager {

    public boolean isRollAccessibleForForkLift(Grid grid, Icon iconToCheck, long adjectLimit) {

        int adjectCount = 0;
        AdjectDetector adjectDetector = new AdjectDetector();
        if (adjectDetector.adjectAbove(grid,iconToCheck)) {
            adjectCount++;
        }
        if (adjectDetector.adjectAboveRight(grid,iconToCheck)) {
            adjectCount++;
        }
        if (adjectDetector.adjectRight(grid,iconToCheck)) {
            adjectCount++;
        }
        if (adjectDetector.adjectRightBelow(grid,iconToCheck)) {
            adjectCount++;
        }
        if (adjectDetector.adjectBelow(grid,iconToCheck)) {
            adjectCount++;
        }
        if (adjectDetector.adjectBelowLeft(grid,iconToCheck)) {
            adjectCount++;
        }
        if (adjectDetector.adjectLeft(grid,iconToCheck)) {
            adjectCount++;
        }
        if (adjectDetector.adjectLeftAbove(grid,iconToCheck)) {
            adjectCount++;
        }
        return adjectCount < adjectLimit;
    }

    public long calculateRollsAccessible(Grid grid) {
        long amountOfRollsAccessible = 0;

        for (int y = 0; y < grid.getRows().size(); y++) {

            Row row = grid.getRow(y);
            for (Icon icon: row.getRowContent()) {
                if (icon.getSymbol().equals("@")){
                    if (isRollAccessibleForForkLift(grid,icon,4)) {
                        amountOfRollsAccessible++;
                    }
                }
            }
        }

        return amountOfRollsAccessible;

    }

    public Row changeRollToCros(Row row, Icon icon) {
        row.getRowContent().get(icon.getX()).setSymbol("X");
        return row;
    }

}
