package com.example.AdventOfCode;
import java.util.Comparator;
import java.util.List;

public class JunctioBoxHelper {

    public List<JunctionBoxPair> sortJunctionBoxPairs(List<JunctionBoxPair> input) {
         return  input.stream()
                .sorted(Comparator.comparingDouble(JunctionBoxPair::distance))
                .toList();
    }
}
