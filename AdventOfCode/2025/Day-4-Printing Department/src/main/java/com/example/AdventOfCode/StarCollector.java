package com.example.AdventOfCode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class StarCollector {

    public long partOne(String filename) throws URISyntaxException, IOException {
        InputHelper inputHelper = new InputHelper();
        List<String> input = inputHelper.loadInput(filename);
        Grid grid = inputHelper.convertInputToGrid(input);
        GridManager gridManager = new GridManager();
        return gridManager.calculateRollsAccessible(grid);
    }

}
