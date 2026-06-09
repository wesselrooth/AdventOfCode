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

        for (int i = 0; i < amountOfPairs; i++) {

            JunctionBoxPair current = sortenList.get(i);
            Circuit leftCircuit = current.left().getCircuit();
            Circuit rigtCircuit = current.right().getCircuit();

            if (leftCircuit == null && rigtCircuit == null){
                Circuit circuit = new Circuit();
                circuit.addJunctionBox(current.left());
                circuit.addJunctionBox(current.right());

                current.left().setCircuit(circuit);
                current.right().setCircuit(circuit);

                circuits.add(circuit);
            }
            else if (leftCircuit != null && rigtCircuit == null){
                leftCircuit.addJunctionBox(current.right());
                current.right().setCircuit(leftCircuit);
                current.left().setCircuit(leftCircuit);
            }
            else if (leftCircuit == null && rigtCircuit != null){
                rigtCircuit.addJunctionBox(current.left());
                current.left().setCircuit(rigtCircuit);
                current.right().setCircuit(rigtCircuit);
            }else if (leftCircuit != null && rigtCircuit != null){

                if (leftCircuit == rigtCircuit){
                    continue;
                }

                Circuit circuit = leftCircuit;
                for (JunctionBox junctionBox : rigtCircuit.getJunctionsBoxes()) {
                    circuit.addJunctionBox(junctionBox);
                    junctionBox.setCircuit(circuit);
                }
                circuits.add(circuit);
                rigtCircuit.setIgnore(true);
            }
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
