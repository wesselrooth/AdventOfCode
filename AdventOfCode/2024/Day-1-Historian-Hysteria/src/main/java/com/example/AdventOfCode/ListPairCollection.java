package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListPairCollection {
    public record ListPair(List<Integer> left, List<Integer> right) {

        public ListPair sort(){
            List<Integer> sortedLeft = new ArrayList<>(left);
            List<Integer> sortedRight = new ArrayList<>(right);
            Collections.sort(sortedLeft);
            Collections.sort(sortedRight);

            return new ListPair(sortedLeft,sortedRight);
        }
    }

}
