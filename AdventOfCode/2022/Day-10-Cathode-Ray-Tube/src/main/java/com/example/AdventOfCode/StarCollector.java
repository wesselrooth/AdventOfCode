package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.CycleException;
import com.example.AdventOfCode.exceptions.SpriteException;
import com.example.AdventOfCode.io.InputLoader;
import com.example.AdventOfCode.managers.CycleManager;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class StarCollector {

    public long partOne(String file) throws URISyntaxException, IOException, CycleException, SpriteException {

        CycleManager cycleManager = new CycleManager(List.of(20L,60L,100L,140L,180L,220L),40);

        InputLoader inputLoader = new InputLoader();
        List<String> cycleList = inputLoader.loadInput(file);

        return cycleManager.calculateSignalStrength(cycleList);
    }

    public List<String> partTwo(String file) throws URISyntaxException, IOException, CycleException, SpriteException {

        CycleManager cycleManager = new CycleManager(List.of(40L,80L,120L,160L,200L,240L),40);

        InputLoader inputLoader = new InputLoader();
        List<String> cycleList = inputLoader.loadInput(file);

        cycleManager.calculateSignalStrength(cycleList);

        return cycleManager.getCheckList();
    }
}
