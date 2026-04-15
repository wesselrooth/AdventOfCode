package com.example.AdventOfCode;

import java.util.List;

public class Grid {

    private List<Row> gridContent;

    public Grid(List<Row> gridContent){
        this.gridContent = gridContent;
    }

    public Row getRow(int i){
        return gridContent.get(i);
    }
}
