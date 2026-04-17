package com.example.AdventOfCode;

public class GridManager {

    public boolean isRollAccessilbeForForkLift(Grid grid, Icon iconToCheck,long adjectLimit){

        int adjectCount = 0;

        if (!(iconToCheck.getY() + 1 >= grid.getRows().size())){
            Row nextRow = grid.getRow(iconToCheck.getY() + 1);
            Icon iconBelow = nextRow.getItem(iconToCheck.getX());
            if (iconBelow.getSymbol().equals("@")){
                adjectCount++;
            }
        }
        if (!(iconToCheck.getY() == 0)){
            Row rowAbove = grid.getRow(iconToCheck.getY() - 1 );
            Icon iconAbove = rowAbove.getItem(iconToCheck.getX());

            if (iconAbove.getSymbol().equals("@")){
                adjectCount++;
            }
        }
        Row row = grid.getRow(iconToCheck.getY());
        if (!(iconToCheck.getX() + 1 >= row.getRowContent().size())){
            Icon iconRight = row.getItem(iconToCheck.getX() + 1);
            if (iconRight.getSymbol().equals("@")){
                adjectCount++;
            }
        }
        if (!(iconToCheck.getX() == 0 )){
            Icon iconLeft = row.getItem(iconToCheck.getX() -1);
            if (iconLeft.getSymbol().equals("@")){
                adjectCount++;
            }
        }
        return adjectCount < adjectLimit;
    }

}
