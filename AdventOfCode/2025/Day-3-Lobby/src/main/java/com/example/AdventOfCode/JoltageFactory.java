package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.InputException;
import org.apache.logging.log4j.core.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoltageFactory {

    public long getJoltage(String input) throws InputException {

        if (input == null || input.isEmpty()){
            throw new InputException("Input is null or size is null");
        }
        StringHelper stringHelper = new StringHelper();
        List<Integer> numberList = stringHelper.convertToListOfInteger(input);

        return stringHelper.get2HighestNumbers(numberList);
    }

    public long getJoltage(String input, int amount) throws InputException {

        if (input == null || input.isEmpty()){
            throw new InputException("Input is null or size is null");
        }
        StringHelper stringHelper = new StringHelper();
        List<Integer> numberList = stringHelper.convertToListOfInteger(input);

        long highestNumber = 0;

        String baseNumber = input.substring(0,amount);

        for(int i = amount; i < numberList.size(); i++) {

            int nextNumber = numberList.get(i);

            for (int letterIndex = 0; letterIndex < baseNumber.length(); letterIndex++){

                String[] baseNumberArray = baseNumber.split("");

                List<String> newStringList = new ArrayList<>(
                        Arrays.asList(ArrayUtils.remove(baseNumberArray,letterIndex))
                );

                newStringList.add(String.valueOf(nextNumber));

                String newHighestNumberString = newStringList.stream().collect(Collectors.joining());

                long highestValue = Long.valueOf(newHighestNumberString);

                if (highestValue > highestNumber){
                    highestNumber = highestValue;
                }

            }

        }
        return highestNumber;
    }


}
