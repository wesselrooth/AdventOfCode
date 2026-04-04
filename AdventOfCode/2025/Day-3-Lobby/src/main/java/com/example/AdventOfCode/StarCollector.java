package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.InputException;
import recourcemanager.InputLoader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class StarCollector {

    InputLoader inputLoader = new InputLoader();

    StringHelper helper = new StringHelper();

    public long partOne(String filename) throws URISyntaxException, IOException, InputException {

        List<String> input = inputLoader.loadInput(filename);

        long result = 0;

        for (String bank: input){
            JoltageFactory joltageInterface = new JoltageFactory();
            result += joltageInterface.getJoltage(bank);
        }
        return result;
    }
}
