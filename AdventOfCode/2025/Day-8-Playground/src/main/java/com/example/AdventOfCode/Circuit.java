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
    public JunctionBox getJunctionBox(int index) {
        return junctionsBoxes.get(index);
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

    public boolean junctionHaveTheSameCoordinate(JunctionBox current) {
        for (JunctionBox junctionBox : junctionsBoxes) {

            if (junctionBox.equals(current)) {
                continue;
            }

            if (junctionBox.getX() == current.getX() && junctionBox.getY() == current.getY() && junctionBox.getZ() == current.getZ()) {
                return true;
            }
        }
        return false;
    }

    public boolean junctionBoxesAlreadyInTheSameCircuit(JunctionBox junctionBox1, JunctionBox junctionBox2) {

        int count = 0;
        for (JunctionBox box : junctionsBoxes) {
            if (box.equals(junctionBox1) | box.equals(junctionBox2)) {
                count++;
            }
        }

        if (count > 2){
            throw new CircuitException("JunctionBoxes appear more then once");
        }

        return count == 2;
    }

}
