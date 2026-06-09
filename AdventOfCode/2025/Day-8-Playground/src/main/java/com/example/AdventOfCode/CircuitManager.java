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
            Circuit leftCircuit = null;
            Circuit rigtCircuit = null;

            for (Circuit circuit : circuits) {

                if (circuit.isIgnore()){
                    continue;
                }


                if (circuit.junctionBoxExistsInCircuit(current.left())){
                    leftCircuit = circuit;
                }
                if (circuit.junctionBoxExistsInCircuit(current.right())){
                    rigtCircuit = circuit;
                }
            }

            if (leftCircuit == null && rigtCircuit == null){
                Circuit circuit = new Circuit();
                circuit.addJunctionBox(current.left());
                circuit.addJunctionBox(current.right());
                circuits.add(circuit);
            }else if (leftCircuit == rigtCircuit){
                //nothing happens
            }
            else if (leftCircuit != null && rigtCircuit == null){
                leftCircuit.addJunctionBox(current.right());
            }
            else if (leftCircuit == null && rigtCircuit != null){
                rigtCircuit.addJunctionBox(current.left());
            }else if (leftCircuit != null && rigtCircuit != null){
                leftCircuit.setIgnore(true);
                rigtCircuit.setIgnore(true);
                Circuit circuit = new Circuit();
                for (JunctionBox junctionBox : leftCircuit.getJunctionsBoxes()) {
                    circuit.addJunctionBox(junctionBox);
                }
                for (JunctionBox junctionBox : rigtCircuit.getJunctionsBoxes()) {
                    circuit.addJunctionBox(junctionBox);
                }
                circuits.add(circuit);
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
