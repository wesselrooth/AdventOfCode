package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class Circuit {

    private List<JunctionBox>  junctionsBoxes;
    private boolean ignore;

    public Circuit() {
        junctionsBoxes = new ArrayList<>();
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

    public void setIgnore(boolean ignore){
        this.ignore = ignore;
    }

    public boolean isIgnore() {
        return ignore;
    }
}
