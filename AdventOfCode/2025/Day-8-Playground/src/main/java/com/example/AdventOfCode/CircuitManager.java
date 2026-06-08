package com.example.AdventOfCode;
import java.util.ArrayList;
import java.util.List;

public class CircuitManager {

    private List<Circuit> circuits;

    public  CircuitManager() {
        circuits = new ArrayList<>();
    }

    public List<Circuit> calculateCircuits(List<JunctionBoxPair> junctionBoxPairs, int amountOfPairs) {

        JunctionBoxLoop: for (int i = 0; i < amountOfPairs; i++) {

            JunctionBoxPair current = junctionBoxPairs.get(i);

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
        return circuits;
    }

    private JunctionBox findClosesJunctionBox(JunctionBox current, List<JunctionBox> junctionBoxList) {

        JunctionBox closesdJuncionBox = null;
        Double junctionBoxDistance = null;

        for (JunctionBox junctionBox : junctionBoxList) {

            if (junctionBox.equals(current)) {
                continue;
            }

            if (junctionBox == null) {
                closesdJuncionBox = junctionBox;
            }
            DistanceCalculator distanceCalculator = new DistanceCalculator();
            double distance = distanceCalculator.calculateEuclideanDistance(current, junctionBox);

            if (junctionBoxDistance == null) {
                junctionBoxDistance = distance;
            } else if (distance > junctionBoxDistance) {
                continue;
            }
            closesdJuncionBox = junctionBox;
        }

        return closesdJuncionBox;
    }

}
