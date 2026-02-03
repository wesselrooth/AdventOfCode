package com.example.AdventOfCode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class StarCollector {

    public int partOne(String file) throws URISyntaxException, IOException {
        InputLoader inputLoader = new InputLoader();

        List<List<String>> input = inputLoader.loadInput(file);
        BeamManager manager = new BeamManager();
        InputLoader loader = new InputLoader();
        Grid grid = loader.convertRawInputToGrid(input);
        grid = manager.locateInitialBeam(grid);
        List<Splitter> splitterList = manager.findAllSplitter(grid);
        grid = manager.createNewBeams(grid,splitterList);
        grid = manager.extendAllBeams(grid);


        int result = manager.countTouchingBeamsToSplitter(grid);

        return result;
    }

    public int partTwoPrepTest(String file) throws URISyntaxException, IOException {
        InputLoader inputLoader = new InputLoader();

        List<List<String>> input = inputLoader.loadInput(file);
        BeamManager manager = new BeamManager();
        InputLoader loader = new InputLoader();
        Grid grid = loader.convertRawInputToGrid(input);

        grid = manager.locateInitialBeam(grid);

        List<Splitter> splitterList = manager.findAllSplitter(grid);
        grid = manager.createNewBeams(grid,splitterList);
        grid = manager.extendAllBeams(grid);

        int result = manager.findPathsDownInGrid(grid);

        return result;
    }

}
