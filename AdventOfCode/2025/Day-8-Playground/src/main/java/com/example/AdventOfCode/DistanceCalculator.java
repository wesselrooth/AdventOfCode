package com.example.AdventOfCode;
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

        List<JunctionBoxPair> junctionBoxPairs = new ArrayList<>();
        for (JunctionBox current : junctionBoxes) {

            for (JunctionBox junctionBox : junctionBoxes) {
                if (junctionBox.equals(current)) {
                    continue;
                }

                double distance = calculateEuclideanDistance(current, junctionBox);
                junctionBoxPairs.add(new JunctionBoxPair(current, junctionBox, distance));
            }
        }

        return junctionBoxPairs;
    }

    public List<JunctionBoxPair> sortJunctionBoxPairs(List<JunctionBoxPair> input) {

        List<JunctionBoxPair> sortedJunctionBoxPairs = new ArrayList<>();

        for (JunctionBoxPair current : input) {

            if (sortedJunctionBoxPairs.isEmpty()) {
                sortedJunctionBoxPairs.add(current);
                continue;
            }

            int insertIndex = 0;
            for (int i = 0; i < sortedJunctionBoxPairs.size(); i++) {
                JunctionBoxPair junctionBoxPair = sortedJunctionBoxPairs.get(i);
                if (current.distance() <= junctionBoxPair.distance()) {
                    insertIndex = i;
                    break;
                }

                insertIndex = i;

                if ((i == sortedJunctionBoxPairs.size() - 1 ) && current.distance() < junctionBoxPair.distance() ) {
                    insertIndex = i;
                }
                if ((i == sortedJunctionBoxPairs.size() - 1 ) && current.distance() > junctionBoxPair.distance() ) {
                    insertIndex = i + 1;
                }
            }
            sortedJunctionBoxPairs.add(insertIndex, current);

        }

        return sortedJunctionBoxPairs;
    }
}
