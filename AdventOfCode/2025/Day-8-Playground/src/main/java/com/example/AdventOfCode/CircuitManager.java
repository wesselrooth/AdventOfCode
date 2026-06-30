package com.example.AdventOfCode;
import com.example.AdventOfCode.exceptions.CircuitException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CircuitManager {

    public List<Circuit> calculateCircuits(List<JunctionBoxPair> pairList, int amountOfPairs) {

        if (pairList == null || pairList.isEmpty()) {
            throw new CircuitException("Empty Junction Box Pair List");
        }

        final List<Circuit> circuits = new ArrayList<>();

        pairList = sortJunctionBoxPairsByDistance(pairList);

        for (int i = 0; i < amountOfPairs; i++) {

            JunctionBoxPair current = pairList.get(i);

            JunctionBox left = current.left();
            JunctionBox right = current.right();

            Circuit leftCircuit = left.getCircuit();
            Circuit rightCircuit = right.getCircuit();

            if (leftCircuit == null && rightCircuit == null) {
                Circuit circuit = new Circuit();
                circuit.addJunctionBox(left);
                circuit.addJunctionBox(right);

                left.setCircuit(circuit);
                right.setCircuit(circuit);

                circuits.add(circuit);
            }else if (leftCircuit != null && rightCircuit == null) {
                leftCircuit.addJunctionBox(right);
                right.setCircuit(leftCircuit);
            } else if (leftCircuit == null && rightCircuit != null) {
                rightCircuit.addJunctionBox(left);
                left.setCircuit(rightCircuit);
            }else if (leftCircuit == rightCircuit) {
                // Left circuit and right are the same, so no merge is needed
            }else {

                for (JunctionBox box : rightCircuit.getJunctionsBoxes()) {
                    leftCircuit.addJunctionBox(box);
                    box.setCircuit(leftCircuit);
                }
                circuits.remove(rightCircuit);
            }
        }
        return circuits;
    }

    public List<Circuit> calculateCircuits(List<JunctionBox> junctionBoxList) {

        DistanceCalculator distanceCalculator = new DistanceCalculator();
        List<JunctionBoxPair> pairList = distanceCalculator.calculateJunctionBoxPairDistances(junctionBoxList);
        pairList = sortJunctionBoxPairsByDistance(pairList);

        final List<Circuit> circuits = new ArrayList<>();

        for (int i = 0; i < pairList.size(); i++) {

            JunctionBoxPair current = pairList.get(i);

            JunctionBox left = current.left();
            JunctionBox right = current.right();

            Circuit leftCircuit = left.getCircuit();
            Circuit rightCircuit = right.getCircuit();

            if (leftCircuit == null && rightCircuit == null) {
                Circuit circuit = new Circuit();
                circuit.addJunctionBox(left);
                circuit.addJunctionBox(right);

                left.setCircuit(circuit);
                right.setCircuit(circuit);

                circuits.add(circuit);
            }else if (leftCircuit != null && rightCircuit == null) {
                leftCircuit.addJunctionBox(right);
                right.setCircuit(leftCircuit);
            } else if (leftCircuit == null && rightCircuit != null) {
                rightCircuit.addJunctionBox(left);
                left.setCircuit(rightCircuit);

            }else if (leftCircuit == rightCircuit) {
                // Left circuit and right are the same, so no merge is needed
            }else {
                for (JunctionBox box : rightCircuit.getJunctionsBoxes()) {
                    leftCircuit.addJunctionBox(box);
                    box.setCircuit(leftCircuit);
                }
                circuits.remove(rightCircuit);
            }

            if (leftCircuit != null && leftCircuit.getJunctionsBoxes().size() == junctionBoxList.size()) {
                leftCircuit.setLargestJunctionBoxDistance(left.getX() * right.getX());
                break;
            }

            if (rightCircuit != null &&rightCircuit.getJunctionsBoxes().size() == junctionBoxList.size()) {
                rightCircuit.setLargestJunctionBoxDistance(right.getX() * left.getX());
                break;
            }
        }
        return circuits;
    }

    private List<JunctionBoxPair> sortJunctionBoxPairsByDistance (List<JunctionBoxPair> junctionBoxPairs) {
        junctionBoxPairs.sort(Comparator.comparingDouble(JunctionBoxPair::distance));
        return junctionBoxPairs;
    }
}
