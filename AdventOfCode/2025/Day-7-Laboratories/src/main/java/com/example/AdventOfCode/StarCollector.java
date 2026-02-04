package com.example.AdventOfCode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class StarCollector {

    public long partOne(String file) throws URISyntaxException, IOException {
        InputLoader inputLoader = new InputLoader();

        List<List<String>> input = inputLoader.loadInput(file);
        BeamManager manager = new BeamManager();

        Grid grid = inputLoader.convertRawInputToGrid(input);
        grid = manager.locateInitialBeam(grid);
        List<Splitter> splitterList = manager.findAllSplitter(grid);
        grid = manager.createNewBeams(grid,splitterList);
        grid = manager.extendAllBeams(grid);

        long result = manager.countTouchingBeamsToSplitter(grid);

        return result;
    }

    public long partTwoPrepTest(String file) throws URISyntaxException, IOException {
        InputLoader inputLoader = new InputLoader();
        List<List<String>> input = inputLoader.loadInput(file);
        BeamManager manager = new BeamManager();

        Grid grid = inputLoader.convertRawInputToGrid(input);

        grid = manager.locateInitialBeam(grid);

        List<Splitter> splitterList = manager.findAllSplitter(grid);
        grid = manager.createNewBeams(grid,splitterList);
        grid = manager.extendAllBeams(grid);

        long result = manager.findPathsDownInGrid(grid);

        return result;
    }

}
