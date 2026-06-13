package com.example.AdventOfCode;
import com.example.AdventOfCode.exceptions.CircuitException;

import java.util.ArrayList;
import java.util.List;

public class DistanceCalculator {

    public double calculateEuclideanDistance(JunctionBox box1, JunctionBox box2) {
        double xDistance = Math.pow(box1.getX() - box2.getX(), 2);
        double yDistance = Math.pow(box1.getY() - box2.getY(), 2);
        double zDistance = Math.pow(box1.getZ() - box2.getZ(), 2);
        double sum = xDistance + yDistance + zDistance;
        return Math.sqrt(sum);
    }

    public List<JunctionBoxPair> calculateJunctionBoxPairDistances(List<JunctionBox> junctionBoxes) {

        if (junctionBoxes == null || junctionBoxes.isEmpty()) {
            throw new CircuitException("Junction Box list is empty");
        }

        List<JunctionBoxPair> junctionBoxPairs = new ArrayList<>();

        for (int i = 0; i < junctionBoxes.size(); i++) {
            JunctionBox current  = junctionBoxes.get(i);

            for (int j = i+1; j < junctionBoxes.size(); j++) {
                JunctionBox toCalculate = junctionBoxes.get(j);
                double distance = calculateEuclideanDistance(current, toCalculate);
                junctionBoxPairs.add(new JunctionBoxPair(current, toCalculate, distance));
            }
        }
        return junctionBoxPairs;
    }
}
