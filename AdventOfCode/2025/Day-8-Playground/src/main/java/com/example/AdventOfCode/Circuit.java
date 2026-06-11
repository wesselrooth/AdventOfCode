package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Circuit {

    private Set<JunctionBox> junctionsBoxes;

    public Circuit() {
        junctionsBoxes  = new ArrayList<>();

    }

    public void addJunctionBox(JunctionBox junctionBox) {
        junctionBox.setCircuit(this);
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
}
