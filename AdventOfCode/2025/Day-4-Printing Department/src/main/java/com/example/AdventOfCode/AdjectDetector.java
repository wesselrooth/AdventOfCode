package com.example.AdventOfCode;

public class AdjectDetector {

    public boolean adjectAbove(Grid grid,Icon icon) {
        if (!(icon.getY() == 0)){
            Row rowAbove = grid.getRow(icon.getY() - 1 );
            Icon iconAbove = rowAbove.getItem(icon.getX());
            if (iconAbove.getSymbol().equals("@")){
                return true;
            }
        }
        return false;
    }

    public boolean adjectAboveRight(Grid grid, Icon icon) {
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
        Row row = grid.getRow(icon.getY());
        if (!(icon.getX() + 1 >= row.getRowContent().size())){
            Icon iconRight = row.getItem(icon.getX() + 1);
            if (iconRight.getSymbol().equals("@")){
                return true;
            }
        }
        return false;
    }

    public boolean adjectRightBelow(Grid grid, Icon icon) {
        if (!(icon.getY() + 1 >= grid.getRows().size())) {
            Row nextRow = grid.getRow(icon.getY() + 1);

            if (!(icon.getX() + 1 >= grid.getRows().size())) {
                Icon iconBelowRight = nextRow.getItem(icon.getX() + 1);
                if (iconBelowRight.getSymbol().equals("@")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean adjectBelow(Grid grid, Icon icon) {
        if (!(icon.getY() + 1 >= grid.getRows().size())) {
            Row nextRow = grid.getRow(icon.getY() + 1);
            Icon iconBelow = nextRow.getItem(icon.getX());
            if (iconBelow.getSymbol().equals("@")) {
                return true;
            }
        }
        return false;
    }

    public boolean adjectBelowLeft(Grid grid, Icon icon) {
        if (!(icon.getY() + 1 >= grid.getRows().size())) {
            Row nextRow = grid.getRow(icon.getY() + 1);
            if (!(icon.getX() == 0 )) {
                Icon belowLeft = nextRow.getItem(icon.getX() -1);
                if (belowLeft.getSymbol().equals("@")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean adjectLeft(Grid grid, Icon icon) {
        Row row = grid.getRow(icon.getY());
        if (!(icon.getX() == 0 )) {
            Icon iconLeft = row.getItem(icon.getX() -1);
            if (iconLeft.getSymbol().equals("@")){
                return true;
            }
        }
        return false;
    }

    public boolean adjectLeftAbove(Grid grid, Icon icon) {
        if (!(icon.getY() == 0)) {
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

}
