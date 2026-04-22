package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class InputConverter {

    public List<Long> convertRawInputToListOfId(List<String> inputList){
        List<Long> resultList = new ArrayList<>();
        for (String inputLine : inputList){
            if (inputLine.contains("-")) {
                continue;
            }

            resultList.add(Long.valueOf(inputLine));
        }
        return resultList;
    }

    public List<Range> convertRawInputToListOfRanges(List<String> inputList){
        List<Range> resultList = new ArrayList<>();

        for (String inputLine : inputList){
            if (inputLine.contains("-")) {

                long min = Long.valueOf(inputLine.split("-")[0]);
                long max = Long.valueOf(inputLine.split("-")[1]);

                resultList.add(new Range(min,max));
            }

        }
        return resultList;
    }

}
