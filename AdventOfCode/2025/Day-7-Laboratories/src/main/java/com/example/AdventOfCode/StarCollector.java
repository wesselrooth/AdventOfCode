package com.example.AdventOfCode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class StarCollector {

    public int partOne() throws URISyntaxException, IOException {
        InputLoader inputLoader = new InputLoader();

        List<List<String>> input = inputLoader.loadInput("puzzle-input");
        BeamManager manager = new BeamManager();
        InputLoader loader = new InputLoader();
        Grid grid = loader.convertRawInputToGrid(input);
        grid = manager.locateInitialBeam(grid);
        List<Splitter> splitterList = manager.findAllSplitter(grid);
        Grid updatedInput = manager.createNewBeams(grid,splitterList);
        Grid extendedBeamInput = manager.extendAllBeams(updatedInput);


        int result = manager.countTouchingBeamsToSplitter(extendedBeamInput);

        return result;
    }

}
