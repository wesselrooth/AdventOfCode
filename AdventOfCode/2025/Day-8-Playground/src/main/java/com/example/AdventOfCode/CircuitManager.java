package com.example.AdventOfCode;
import java.util.ArrayList;
import java.util.List;

public class CircuitManager {

    private List<Circuit> circuits;

    public  CircuitManager() {
        circuits = new ArrayList<>();
    }

    public List<Circuit> calculateCircuits(List<JunctionBoxPair> junctionBoxPairs, int amountOfPairs) {

        JunctioBoxHelper junctioBoxHelper = new JunctioBoxHelper();
        List<JunctionBoxPair> sortenList = junctioBoxHelper.sortJunctionBoxPairs(junctionBoxPairs);


        JunctionBoxLoop: for (int i = 0; i < amountOfPairs; i++) {

            JunctionBoxPair current = sortenList.get(i);

            if (circuits.isEmpty()){
                Circuit circuit = new Circuit();
                circuit.addJunctionBox(current.left());
                circuit.addJunctionBox(current.right());
                circuits.add(circuit);
                continue;
            }

            for (Circuit circuit : circuits) {
                if (circuit.junctionBoxesAlreadyInTheSameCircuit(current)) {
                    continue JunctionBoxLoop;
                }

                if (circuit.junctionBoxExistsInCircuit(current.left())){
                    circuit.addJunctionBox(current.right());
                    continue JunctionBoxLoop;
                }
                if (circuit.junctionBoxExistsInCircuit(current.right())){
                    circuit.addJunctionBox(current.left());
                    continue JunctionBoxLoop;
                }

                if (circuit.junctionHaveTheSameCoordinate(current)){
                    circuit.addJunctionBox(current.left());
                    circuit.addJunctionBox(current.right());
                    continue JunctionBoxLoop;
                }
            }

            Circuit circuit = new Circuit();
            circuit.addJunctionBox(current.left());
            circuit.addJunctionBox(current.right());
            circuits.add(circuit);
        }

        for (JunctionBoxPair junctionBoxPair : sortenList) {

            if (junctionBoxPair.left().getCircuit() == null) {
                Circuit circuit = new Circuit();
                circuit.addJunctionBox(junctionBoxPair.left());
                circuits.add(circuit);
            }

            if (junctionBoxPair.right().getCircuit() == null) {
                Circuit circuit = new Circuit();
                circuit.addJunctionBox(junctionBoxPair.right());
                circuits.add(circuit);
            }
        }

        return circuits;
    }

}
