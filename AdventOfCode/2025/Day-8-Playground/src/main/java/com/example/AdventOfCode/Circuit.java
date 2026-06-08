package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.CircuitException;

import java.util.ArrayList;
import java.util.List;

public class Circuit {

    private List<JunctionBox>  junctionsBoxes;

    public Circuit() {
        junctionsBoxes = new ArrayList<>();
    }

    public void addJunctionBox(JunctionBox junctionBox) {
        junctionsBoxes.add(junctionBox);
    }

    public List<JunctionBox> getJunctionsBoxes() {
        return junctionsBoxes;
    }

    public boolean junctionBoxExistsInCircuit(JunctionBox current) {
        for (JunctionBox junctionBox : junctionsBoxes) {
            if (junctionBox.equals(current)) {
                return true;
            }
        }
        return false;
    }

    public boolean junctionHaveTheSameCoordinate(JunctionBoxPair current) {
        for (JunctionBox junctionBox : junctionsBoxes) {

            if (junctionBox.equals(current)) {
                continue;
            }

            if (junctionBox.getX() == current.left().getX() && junctionBox.getY() == current.left().getY() && junctionBox.getZ() == current.left().getZ()) {
                return true;
            }
        }
        return false;
    }

    public boolean junctionBoxesAlreadyInTheSameCircuit(JunctionBoxPair current) {

        int count = 0;
        for (JunctionBox box : junctionsBoxes) {
            if (box.equals(current.left()) | box.equals(current.right())) {
                count++;
            }
        }

        if (count > 2){
            throw new CircuitException("JunctionBoxes appear more then once");
        }

        return count == 2;
    }

}
