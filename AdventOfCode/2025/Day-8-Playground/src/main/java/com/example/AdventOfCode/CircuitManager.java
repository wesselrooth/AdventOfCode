package com.example.AdventOfCode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CircuitManager {

    private List<Circuit> circuits;

    public  CircuitManager() {
        circuits = new ArrayList<>();
    }

    public List<Circuit> calculateCircuits(List<JunctionBoxPair> junctionBoxPairs, int amountOfPairs) {

        List<JunctionBoxPair> sortenList = junctionBoxPairs.stream()
                .sorted(Comparator.comparingDouble(JunctionBoxPair::distance))
                .toList();

        for (int i = 0; i < amountOfPairs; i++) {

            JunctionBoxPair current = sortenList.get(i);
            Circuit leftCircuit = current.left().getCircuit();
            Circuit rightCircuit = current.right().getCircuit();

            if (leftCircuit == null && rightCircuit == null){
                Circuit circuit = new Circuit();
                circuit.addJunctionBox(current.left());
                circuit.addJunctionBox(current.right());

                current.left().setCircuit(circuit);
                current.right().setCircuit(circuit);

                circuits.add(circuit);
            }
            else if (leftCircuit != null && rightCircuit == null){
                leftCircuit.addJunctionBox(current.right());
                current.right().setCircuit(leftCircuit);
                current.left().setCircuit(leftCircuit);
            }
            else if (leftCircuit == null && rightCircuit != null){
                rightCircuit.addJunctionBox(current.left());
                current.left().setCircuit(rightCircuit);
                current.right().setCircuit(rightCircuit);
            }else {

                if (leftCircuit == rightCircuit){
                    continue;
                }

                for (JunctionBox junctionBox : rightCircuit.getJunctionsBoxes()) {
                    leftCircuit.addJunctionBox(junctionBox);
                    junctionBox.setCircuit(leftCircuit);
                }
                rightCircuit.setIgnore(true);
            }
        }

        return circuits;
    }

}
