package com.example.AdventOfCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistanceCalculator {

    public double calculateEuclideanDistance(JunctionBox box1, JunctionBox box2) {
        double xDistance = Math.pow(box1.getX() - box2.getX(), 2);
        double yDistance = Math.pow(box1.getY() - box2.getY(), 2);
        double zDistance = Math.pow(box1.getZ() - box2.getZ(), 2);
        double sum = xDistance + yDistance + zDistance;
        return Math.sqrt(sum);
    }

    public HashMap<DistanceJunctionBoxCombination, Double> calculateJunctionBoxPairDistances(List<JunctionBox> junctionBoxes) {
        junctionBoxes = calculateDistancePerJunctionBox(junctionBoxes);

        return calculateAllDistanceCombinations(junctionBoxes);
    }

    public List<Map.Entry<DistanceJunctionBoxCombination, Double>> sortCollectionOfJunctionBoxCombinationDistances(Map<DistanceJunctionBoxCombination, Double> input) {
        List<Map.Entry<DistanceJunctionBoxCombination, Double>> list = new ArrayList<>(input.entrySet());
        list.sort(Map.Entry.comparingByValue());
        return list;
    }

    public HashMap<DistanceJunctionBoxCombination, Double> calculateAllDistanceCombinations(List<JunctionBox> junctionBoxes) {

        HashMap<DistanceJunctionBoxCombination, Double> connectingBoxes = new HashMap<>();

        for (JunctionBox current : junctionBoxes) {
            for (Map.Entry<JunctionBox, Double> other : current.getDistanceMap().entrySet()) {
                DistanceJunctionBoxCombination distanceJunctionBoxCombination = new DistanceJunctionBoxCombination(other.getKey(),current);
                connectingBoxes.put(distanceJunctionBoxCombination, other.getValue());
            }
        }
        return connectingBoxes;
    }

    private List<JunctionBox> calculateDistancePerJunctionBox(List<JunctionBox> junctionBoxList) {
        for (JunctionBox current : junctionBoxList) {

            for (JunctionBox junctionBox : junctionBoxList) {
                if (junctionBox.equals(current)) {
                    continue;
                }
                double distance  = calculateEuclideanDistance(current, junctionBox);
                current.addDistance(junctionBox, distance);
            }
        }
        return junctionBoxList;
    }

}
