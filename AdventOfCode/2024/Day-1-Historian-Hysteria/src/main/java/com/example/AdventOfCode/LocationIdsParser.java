package com.example.AdventOfCode;
import com.example.AdventOfCode.Parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocationIdsParser {

    private final Parser parser;

    public LocationIdsParser(Parser parser){
        this.parser = parser;
    }
    public ListPairCollection.ListPair parse(List<String> inputList) {

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (String input : inputList) {
            Parser.intPairRecord intPairRecord = parser.parseLine(input);
            left.add(intPairRecord.left());
            right.add(intPairRecord.right());
        }
        return new ListPairCollection.ListPair(left, right);
    }
}
