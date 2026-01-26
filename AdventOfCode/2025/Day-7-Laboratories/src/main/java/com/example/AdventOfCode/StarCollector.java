package com.example.AdventOfCode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class StarCollector {

    public int partOne() throws URISyntaxException, IOException {
        InputLoader inputLoader = new InputLoader();
        List<List<String>> input = inputLoader.loadInput("puzzle-input");
        BeamManager manager = new BeamManager();


        List<Splitter> splitterList = manager.findAllSplitter(input);
        List<List<String>> updatedInput = manager.createNewBeams(input,splitterList);
        List<List<String>> extendedBeamInput = manager.extendBeam(updatedInput);
        int result = manager.countTouchingBeamsToSplitter(extendedBeamInput);

        result++;
        return result;
    }

}
