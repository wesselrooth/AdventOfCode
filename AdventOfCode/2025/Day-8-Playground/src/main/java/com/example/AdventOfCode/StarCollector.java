package com.example.AdventOfCode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;

public class StarCollector {

    public long partOne(String file,int pairs) throws URISyntaxException, IOException  {
        InputLoader inputLoader = new InputLoader();
        List<JunctionBox> input = inputLoader.loadInput(file);

        DistanceCalculator distanceCalculator = new DistanceCalculator();
        List<JunctionBoxPair> junctionBoxPairs = distanceCalculator.calculateJunctionBoxPairDistances(input);
        CircuitManager circuitManager = new CircuitManager();
        List<Circuit> circuitList = circuitManager.calculateCircuits(junctionBoxPairs,pairs);

        circuitList.sort(Comparator.comparingInt( (Circuit c) -> c.getJunctionsBoxes().size()).reversed());

        long result = 0;
        for (int i =0; i< 3; i++) {

            Circuit circuit = circuitList.get(i);
            if (i == 0){
                result = circuit.getJunctionsBoxes().size();
                continue;
            }
            result *= circuit.getJunctionsBoxes().size();
        }
        return result;
    }
}
