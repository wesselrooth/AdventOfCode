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


        if (input == null || input.isEmpty()){
            throw new InputException("Input is null or size is null");
        }
        if (numberList.size() < 2 ){
            throw new InputException("Inputsize is less the 2");
        }

        long highestNumber = 0;

        for(int i = 0; i< numberList.size(); i++) {
            int baseNumber = numberList.get(i);
            for (int y = i + 1; y< numberList.size(); y++){
                int nextNumber = numberList.get(y);

                long combinedNumber = Long.parseLong("" + baseNumber + nextNumber);
                if (combinedNumber > highestNumber){
                    highestNumber = combinedNumber;
                }
            }
        }
        return highestNumber;
    }

    public long getJoltage(String input, int amount) throws InputException {

        if (input == null || input.isEmpty()){
            throw new InputException("Input is null or size is null");
        }
        StringHelper stringHelper = new StringHelper();
        List<Integer> numberList = stringHelper.convertToListOfInteger(input);

        String baseNumber = input.substring(0,amount);
        long highestNumber = Long.valueOf(baseNumber);

        for(int i = amount; i < numberList.size(); i++) {

            int nextNumber = numberList.get(i);

            for (int baseNumberIndex = 0; baseNumberIndex < baseNumber.length(); baseNumberIndex++){

                String[] baseNumberArray = baseNumber.split("");
                List<String> newStringList = new ArrayList<>(
                        Arrays.asList(ArrayUtils.remove(baseNumberArray, baseNumberIndex))
                );

                newStringList.add(String.valueOf(nextNumber));
                String newHighestNumberString = newStringList.stream().collect(Collectors.joining());
                long newCreatedNumber = Long.valueOf(newHighestNumberString);

                if (newCreatedNumber > highestNumber){
                    highestNumber = newCreatedNumber;
                }

            }

            baseNumber = String.valueOf(highestNumber);

        }
        return highestNumber;
    }


}
