package com.example.AdventOfCode;

import com.example.AdventOfCode.resources.InputLoader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

public class StarCollector {

    public long partOne(String file,int pairs) throws URISyntaxException, IOException  {
        InputLoader inputLoader = new InputLoader();
        List<JunctionBox> input = inputLoader.loadInput(file);

        DistanceCalculator distanceCalculator = new DistanceCalculator();
        List<JunctionBoxPair> junctionBoxPairs = distanceCalculator.calculateJunctionBoxPairDistances(input);
        CircuitManager circuitManager = new CircuitManager();
        List<Circuit> circuitList = circuitManager.calculateCircuits(junctionBoxPairs,pairs);
        Collections.sort(circuitList);
        long result = 0;
        for (int i =0; i < 3; i++) {

            Circuit circuit = circuitList.get(i);
            if (i == 0){
                result = circuit.getJunctionsBoxes().size();
            }else {
                result *= circuit.getJunctionsBoxes().size();
            }
        }
        return result;
    }

    public long partTwo(String file) throws URISyntaxException, IOException  {
        InputLoader inputLoader = new InputLoader();
        List<JunctionBox> input = inputLoader.loadInput(file);
        CircuitManager circuitManager = new CircuitManager();
        List<Circuit> circuitList = circuitManager.calculateCircuits(input);
        return circuitList.getFirst().getLargestJunctionBoxDistance();
    }
}
