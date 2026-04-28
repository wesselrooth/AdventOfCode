package com.example.AdventOfCode;

import java.util.List;

public class GridHelper {

    public Grid calculateColumnsForGrid(Grid grid){


        for (int columnIndex = 0; columnIndex < grid.getRow(0).rowContent.size(); columnIndex++) {
            Collumn collumn = new Collumn();

            for (int rowIndex = 0; rowIndex < grid.getRows().size(); rowIndex++) {
                String itemString  = grid.getRow(rowIndex).getRowContent().get(columnIndex);

                try {
                    Long number = Long.valueOf(itemString);
                    collumn.addNumber(number);
                } catch (NumberFormatException e) {

                    if (itemString.equals("*") | itemString.equals("+")){
                        collumn.setOparent(itemString);
                    }else {
                        throw new IllegalArgumentException("Unexpected value: " + itemString);
                    }
                }
            }
            grid.addCollumn(collumn);
        }
        return grid;
    }
}
