package com.example.AdventOfCode;
import java.util.ArrayList;
import java.util.List;

public class CircuitManager {

    private List<Circuit> circuits;

    public  CircuitManager() {
        circuits = new ArrayList<>();
    }

    public List<Circuit> calculateCircuits(List<JunctionBox> junctionBoxes) {

        JunctionBoxLoop: for (JunctionBox current : junctionBoxes) {
            JunctionBox closesdJunctionBox = findClosesJunctionBox(current,junctionBoxes);
            if (circuits.isEmpty()){
                Circuit circuit = new Circuit();
                circuit.addJunctionBox(current);
                circuit.addJunctionBox(closesdJunctionBox);
                circuits.add(circuit);
                continue;
            }

            for (Circuit circuit : circuits) {
                if (circuit.junctionBoxesAlreadyInTheSameCircuit(current,closesdJunctionBox)) {
                    continue JunctionBoxLoop;
                }

                if (circuit.junctionBoxExistsInCircuit(current)){
                    circuit.addJunctionBox(closesdJunctionBox);
                    continue JunctionBoxLoop;
                }
                if (circuit.junctionBoxExistsInCircuit(closesdJunctionBox)){
                    circuit.addJunctionBox(current);
                    continue JunctionBoxLoop;
                }

                if (circuit.junctionHaveTheSameCoordinate(current)){
                    circuit.addJunctionBox(current);
                    circuit.addJunctionBox(closesdJunctionBox);
                    continue JunctionBoxLoop;
                }


            }

            Circuit circuit = new Circuit();
            circuit.addJunctionBox(current);
            circuit.addJunctionBox(closesdJunctionBox);
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
