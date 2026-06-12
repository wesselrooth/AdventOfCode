package com.example.AdventOfCode;
import java.util.*;

public class CircuitManager {

    private List<Circuit> circuits;

    public  CircuitManager() {
        circuits = new ArrayList<>();
    }

    public List<Circuit> calculateCircuits(List<JunctionBoxPair> junctionBoxPairs, int amountOfPairs) {

        List<JunctionBoxPair> sortenList = junctionBoxPairs.stream()
                .sorted(Comparator.comparingDouble(JunctionBoxPair::distance))
                .toList();

        Set<JunctionBox> allBoxes = new HashSet<>();
        for (JunctionBoxPair pair : junctionBoxPairs) {
            allBoxes.add(pair.left());
            allBoxes.add(pair.right());
        }

        for (JunctionBox box : allBoxes) {
            Circuit circuit = new Circuit();
            circuit.addJunctionBox(box);
            box.setCircuit(circuit);
            circuits.add(circuit);
        }

        for (int i = 0; i < amountOfPairs; i++) {

            JunctionBoxPair current = sortenList.get(i);
            Circuit leftCircuit = current.left().getCircuit();
            Circuit rightCircuit = current.right().getCircuit();

            if (leftCircuit == rightCircuit) {
                continue;
            }

            for (JunctionBox rightBox : rightCircuit.getJunctionsBoxes()) {
                leftCircuit.addJunctionBox(rightBox);
                rightBox.setCircuit(leftCircuit);
            }
            circuits.remove(rightCircuit);
        }
        return circuits;
    }

}
