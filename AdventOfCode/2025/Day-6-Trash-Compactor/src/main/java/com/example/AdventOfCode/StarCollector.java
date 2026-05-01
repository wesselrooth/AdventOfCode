package com.example.AdventOfCode;

import java.io.IOException;
import java.net.URISyntaxException;

public class StarCollector {

    public long partOne(String filename) throws URISyntaxException, IOException {
        InputLoader inputLoader = new InputLoader();
        Grid grid = inputLoader.convertInputToGrid(filename);
        GridHelper gridHelper = new GridHelper();
        grid = gridHelper.calculateColumnsForGrid(grid);
        long result = 0;
        ColumnManager columnManager = new ColumnManager();
        for(Collumn collumn: grid.getCollumns()) {
            long columnResult = columnManager.calculateColumnOutput(collumn);
            result += columnResult;
        }
        return result;
    }

    public long partTwo(String filename) throws URISyntaxException, IOException {
        InputLoader inputLoader = new InputLoader();
        Grid grid = inputLoader.convertInputToGrid(filename);
        GridHelper gridHelper = new GridHelper();
        grid = gridHelper.calculateColumnsForGrid(grid);
        long result = 0;
        ColumnManager columnManager = new ColumnManager();
        for(Collumn collumn: grid.getCollumns()) {

            long columnResult = columnManager.calculateColumnOutput(collumn);
            result += columnResult;
        }
        return result;
    }
}
