package com.example.AdventOfCode;
import java.util.HashSet;

import java.util.Set;

public class Circuit {

    private final Set<JunctionBox> junctionsBoxes;
    private long largestJunctionBoxDistance;

    public Circuit() {
        junctionsBoxes  = new HashSet<>();
    }

    public void addJunctionBox(JunctionBox junctionBox) {
        junctionsBoxes.add(junctionBox);
    }

    public Set<JunctionBox> getJunctionsBoxes() {
        return junctionsBoxes;
    }

    public  long getLargestJunctionBoxDistance() {
        return largestJunctionBoxDistance;
    }

    public void setLargestJunctionBoxDistance(long largestJunctionBoxDistance) {
        this.largestJunctionBoxDistance = largestJunctionBoxDistance;
    }
}
