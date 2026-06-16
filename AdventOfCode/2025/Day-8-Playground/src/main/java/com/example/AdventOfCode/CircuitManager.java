package com.example.AdventOfCode;
import com.example.AdventOfCode.exceptions.CircuitException;

import java.util.*;

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
                continue;
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

    private List<JunctionBoxPair> sortJunctionBoxPairsByDistance (List<JunctionBoxPair> junctionBoxPairs) {
        return junctionBoxPairs.stream()
                .sorted(Comparator.comparingDouble(JunctionBoxPair::distance))
                .toList();
    }

    public void sortByCircuitSize(List<Circuit> circuits) {
        circuits.sort(Comparator.comparingInt( (Circuit c) -> c.getJunctionsBoxes().size()).reversed());
    }

}
