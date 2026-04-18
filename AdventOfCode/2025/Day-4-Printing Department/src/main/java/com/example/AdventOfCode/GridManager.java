package com.example.AdventOfCode;

public class GridManager {

    public boolean isRollAccessilbeForForkLift(Grid grid, Icon iconToCheck,long adjectLimit){

        int adjectCount = 0;
        // Above
        if (!(iconToCheck.getY() == 0)){
            Row rowAbove = grid.getRow(iconToCheck.getY() - 1 );
            Icon iconAbove = rowAbove.getItem(iconToCheck.getX());
            if (iconAbove.getSymbol().equals("@")){
                adjectCount++;
            }
        }
        // Above Right
        if (!(iconToCheck.getY() == 0)){
            Row rowAbove = grid.getRow(iconToCheck.getY() - 1 );

            if (!(iconToCheck.getX() + 1 >= rowAbove.getRowContent().size())) {
                Icon aboveRight = rowAbove.getItem(iconToCheck.getX() + 1);
                if (aboveRight.getSymbol().equals("@")){
                    adjectCount++;
                }

            }
        }
        // Right
        Row row = grid.getRow(iconToCheck.getY());
        if (!(iconToCheck.getX() + 1 >= row.getRowContent().size())){
            Icon iconRight = row.getItem(iconToCheck.getX() + 1);
            if (iconRight.getSymbol().equals("@")){
                adjectCount++;
            }
        }

        // Below Right
        if (!(iconToCheck.getY() + 1 >= grid.getRows().size())){
            Row nextRow = grid.getRow(iconToCheck.getY() + 1);

            if (!(iconToCheck.getX() + 1 >= grid.getRows().size())){
                Icon iconBelowRight = nextRow.getItem(iconToCheck.getX() + 1);
                if (iconBelowRight.getSymbol().equals("@")){
                    adjectCount++;
                }
            }
        }

        // Below
        if (!(iconToCheck.getY() + 1 >= grid.getRows().size())){
            Row nextRow = grid.getRow(iconToCheck.getY() + 1);
            Icon iconBelow = nextRow.getItem(iconToCheck.getX());
            if (iconBelow.getSymbol().equals("@")){
                adjectCount++;
            }
        }

        // Below Left
        if (!(iconToCheck.getY() + 1 >= grid.getRows().size())){
            Row nextRow = grid.getRow(iconToCheck.getY() + 1);
            if (!(iconToCheck.getX() == 0 )) {
                Icon belowLeft = nextRow.getItem(iconToCheck.getX() -1);
                if (belowLeft.getSymbol().equals("@")){
                    adjectCount++;
                }
            }
        }

        // left
        if (!(iconToCheck.getX() == 0 )){
            Icon iconLeft = row.getItem(iconToCheck.getX() -1);
            if (iconLeft.getSymbol().equals("@")){
                adjectCount++;
            }
        }

        // left above
        if (!(iconToCheck.getY() == 0)){
            Row rowAbove = grid.getRow( iconToCheck.getY() - 1);

            if (!(iconToCheck.getX() == 0 )){
                Icon iconLeftAbove = rowAbove.getItem(iconToCheck.getX() -1);
                if (iconLeftAbove.getSymbol().equals("@")){
                    adjectCount++;
                }
            }
        }


        return adjectCount < adjectLimit;
    }

}
