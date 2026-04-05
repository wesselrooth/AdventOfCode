package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.InputException;
import recourcemanager.InputLoader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class StarCollector {

    InputLoader inputLoader = new InputLoader();

    public long calucateJoltage(String filename, int joltageSize) throws URISyntaxException, IOException, InputException {

        List<String> input = inputLoader.loadInput(filename);

        long result = 0;

        for (String bank: input){
            JoltageFactory joltageFactory = new JoltageFactory();
            long tmpResult = joltageFactory.getJoltage(bank,joltageSize);
            result += tmpResult;
        }
        return result;
    }


}
