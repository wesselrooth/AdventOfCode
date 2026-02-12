package com.example.AdventOfCode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class StarCollector {

    public long partOne(String file) throws URISyntaxException, IOException, CycleException {

        CycleManager cycleManager = new CycleManager(List.of(20L,60L,100L,140L,180L,220L));

        InputLoader inputLoader = new InputLoader();
        List<String> cycleList = inputLoader.loadInput(file);

        long result = cycleManager.calculateSignalStrengh(cycleList);

        return result;

    }
}
