package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.CycleException;
import com.example.AdventOfCode.exceptions.SpriteException;
import com.example.AdventOfCode.io.InputLoader;
import com.example.AdventOfCode.managers.CircuitManager;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class StarCollector {

    public long partOne(String file) throws URISyntaxException, IOException, CycleException, SpriteException {

        CircuitManager.CycleManager cycleManager = new CircuitManager.CycleManager(List.of(20L,60L,100L,140L,180L,220L),40);

        InputLoader inputLoader = new InputLoader();
        List<String> cycleList = inputLoader.loadInput(file);

        long result = cycleManager.calculateSignalStrength(cycleList);

        return result;
    }

    public Map<Long,String> partTwo(String file) throws URISyntaxException, IOException, CycleException, SpriteException {

        CircuitManager.CycleManager cycleManager = new CircuitManager.CycleManager(List.of(40L,80L,120L,160L,200L,240L),40);

        InputLoader inputLoader = new InputLoader();
        List<String> cycleList = inputLoader.loadInput(file);

        cycleManager.calculateSignalStrength(cycleList);

        return cycleManager.getCircuitStringMap();
    }
}
