package com.example.AdventOfCode;
import java.util.*;

public class CircuitManager {

    private List<Circuit> circuits = new ArrayList<>();

    public List<Circuit> calculateCircuits(List<JunctionBoxPair> junctionBoxPairs, int amountOfPairs) {

        List<JunctionBoxPair> sortenList = junctionBoxPairs.stream()
                .sorted(Comparator.comparingDouble(JunctionBoxPair::distance))
                .toList();

        for (int i = 0; i < amountOfPairs; i++) {

            JunctionBoxPair current = sortenList.get(i);

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

                for (JunctionBox box : leftCircuit.getJunctionsBoxes()) {
                    rightCircuit.addJunctionBox(box);
                    box.setCircuit(rightCircuit);
                }
                circuits.remove(leftCircuit);
            }
        }
        return circuits;
    }

}
