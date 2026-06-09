package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class JunctioBoxHelper {

    public List<JunctionBoxPair> sortJunctionBoxPairs(List<JunctionBoxPair> input) {

        List<JunctionBoxPair> sortedJunctionBoxPairs = new ArrayList<>();

        for (JunctionBoxPair current : input) {

            if (sortedJunctionBoxPairs.isEmpty()) {
                sortedJunctionBoxPairs.add(current);
                continue;
            }

            int insertIndex = 0;
            for (int i = 0; i < sortedJunctionBoxPairs.size(); i++) {
                JunctionBoxPair junctionBoxPair = sortedJunctionBoxPairs.get(i);
                if (current.distance() <= junctionBoxPair.distance()) {
                    insertIndex = i;
                    break;
                }

                insertIndex = i;

                if ((i == sortedJunctionBoxPairs.size() - 1 ) && current.distance() < junctionBoxPair.distance() ) {
                    insertIndex = i;
                }
                if ((i == sortedJunctionBoxPairs.size() - 1 ) && current.distance() > junctionBoxPair.distance() ) {
                    insertIndex = i + 1;
                }
            }
            sortedJunctionBoxPairs.add(insertIndex, current);

        }

        return sortedJunctionBoxPairs;
    }
}
