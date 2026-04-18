package com.example.AdventOfCode;

public class GridManager {


    public boolean isRollAccessibleForForkLift(Grid grid, Icon iconToCheck, long adjectLimit) {

        int adjectCount = 0;
        AdjectDetector adjectDetector = new AdjectDetector();
        if (adjectDetector.adjectAbove(grid,iconToCheck)){
            adjectCount++;
        }
        if (adjectDetector.adjectAboveRight(grid,iconToCheck)){
            adjectCount++;
        }
        if (adjectDetector.adjectRight(grid,iconToCheck)){
            adjectCount++;
        }
        if (adjectDetector.adjectRightBelow(grid,iconToCheck)){
            adjectCount++;
        }
        if (adjectDetector.adjectBelow(grid,iconToCheck)){
            adjectCount++;
        }
        if (adjectDetector.adjectBelowLeft(grid,iconToCheck)){
            adjectCount++;
        }
        if (adjectDetector.adjectLeft(grid,iconToCheck)){
            adjectCount++;
        }
        if (adjectDetector.adjectLeftAbove(grid,iconToCheck)) {
            adjectCount++;
        }
        return adjectCount < adjectLimit;
    }

}
