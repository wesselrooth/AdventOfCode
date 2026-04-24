package com.example.AdventOfCode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class StartCollector {

    public long partOne_DetectAmountOfFreshIds(String filename) throws URISyntaxException, IOException {

        InputLoader inputLoader = new InputLoader();
        List<String> rawInputList = inputLoader.loadInput(filename);
        InputConverter inputConverter = new InputConverter();
        List<Range> rangeList = inputConverter.convertRawInputToListOfRanges(rawInputList);
        List<Long> idList = inputConverter.convertRawInputToListOfId(rawInputList);
        RangeDetector rangeDetector = new RangeDetector(rangeList);
        return rangeDetector.returnFreshIds(idList).size();
    }


    public long partTwo_CalculateAllFreshIds(String filename) throws URISyntaxException, IOException {

        InputLoader inputLoader = new InputLoader();
        List<String> rawInputList = inputLoader.loadInput(filename);
        InputConverter inputConverter = new InputConverter();
        List<Range> rangeList = inputConverter.convertRawInputToListOfRanges(rawInputList);
        RangeDetector rangeDetector = new RangeDetector(rangeList);
        return rangeDetector.calculateFreshIds();
    }
}
