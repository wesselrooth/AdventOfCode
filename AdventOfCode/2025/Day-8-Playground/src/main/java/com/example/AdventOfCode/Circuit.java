package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.Set;

public class Circuit {

    private Set<JunctionBox> junctionsBoxes;

    public Circuit() {
        junctionsBoxes  = new HashSet<>();
    }

    public void addJunctionBox(JunctionBox junctionBox) {
        junctionsBoxes.add(junctionBox);
    }

    public Set<JunctionBox> getJunctionsBoxes() {
        return junctionsBoxes;
    }

}
