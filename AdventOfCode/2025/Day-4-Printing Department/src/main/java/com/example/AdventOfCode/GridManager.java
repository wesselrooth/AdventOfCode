package com.example.AdventOfCode;

public class GridManager {

    private boolean adjectAbove(Grid grid,Icon icon){

        if (!(icon.getY() == 0)){
            Row rowAbove = grid.getRow(icon.getY() - 1 );
            Icon iconAbove = rowAbove.getItem(icon.getX());
            if (iconAbove.getSymbol().equals("@")){
                return true;
            }
        }
        return false;
    }

    private boolean adjectAboveRight(Grid grid, Icon icon) {
        // Above Right
        if (!(icon.getY() == 0)){
            Row rowAbove = grid.getRow(icon.getY() - 1 );
            if (!(icon.getX() + 1 >= rowAbove.getRowContent().size())) {
                Icon aboveRight = rowAbove.getItem(icon.getX() + 1);
                if (aboveRight.getSymbol().equals("@")){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean adjectRight(Grid grid, Icon icon) {
        // Right
        Row row = grid.getRow(icon.getY());
        if (!(icon.getX() + 1 >= row.getRowContent().size())){
            Icon iconRight = row.getItem(icon.getX() + 1);
            if (iconRight.getSymbol().equals("@")){
                return true;
            }
        }
        return false;
    }

    private boolean adjectRightBelow(Grid grid, Icon icon){
        // Below Right
        if (!(icon.getY() + 1 >= grid.getRows().size())){
            Row nextRow = grid.getRow(icon.getY() + 1);

            if (!(icon.getX() + 1 >= grid.getRows().size())){
                Icon iconBelowRight = nextRow.getItem(icon.getX() + 1);
                if (iconBelowRight.getSymbol().equals("@")){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean adjectBelow(Grid grid, Icon icon){

        if (!(icon.getY() + 1 >= grid.getRows().size())){
            Row nextRow = grid.getRow(icon.getY() + 1);
            Icon iconBelow = nextRow.getItem(icon.getX());
            if (iconBelow.getSymbol().equals("@")){
                return true;
            }
        }
        return false;
    }

    private boolean adjectBelowLeft(Grid grid, Icon icon){
        if (!(icon.getY() + 1 >= grid.getRows().size())){
            Row nextRow = grid.getRow(icon.getY() + 1);
            if (!(icon.getX() == 0 )) {
                Icon belowLeft = nextRow.getItem(icon.getX() -1);
                if (belowLeft.getSymbol().equals("@")){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean adjectLeft(Grid grid, Icon icon){

        Row row = grid.getRow(icon.getY());
        if (!(icon.getX() == 0 )){
            Icon iconLeft = row.getItem(icon.getX() -1);
            if (iconLeft.getSymbol().equals("@")){
                return true;
            }
        }
        return false;
    }

    private boolean adjectLeftAbove(Grid grid, Icon icon){

        if (!(icon.getY() == 0)){
            Row rowAbove = grid.getRow( icon.getY() - 1);
            if (!(icon.getX() == 0 )){
                Icon iconLeftAbove = rowAbove.getItem(icon.getX() -1);
                if (iconLeftAbove.getSymbol().equals("@")){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isRollAccessibleForForkLift(Grid grid, Icon iconToCheck, long adjectLimit){

        int adjectCount = 0;

        if (adjectAbove(grid,iconToCheck)){
            adjectCount++;
        }
        if (adjectAboveRight(grid,iconToCheck)){
            adjectCount++;
        }
        if (adjectRight(grid,iconToCheck)){
            adjectCount++;
        }
        if (adjectRightBelow(grid,iconToCheck)){
            adjectCount++;
        }
        if (adjectBelow(grid,iconToCheck)){
            adjectCount++;
        }
        if (adjectBelowLeft(grid,iconToCheck)){
            adjectCount++;
        }
        if (adjectLeft(grid,iconToCheck)){
            adjectCount++;
        }
        if (adjectLeftAbove(grid,iconToCheck)) {
            adjectCount++;
        }
        return adjectCount < adjectLimit;
    }

}
