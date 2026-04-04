package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.InputException;

import java.util.*;

public class StringHelper {

    public List<Integer> convertToListOfInteger(String input) throws InputException {

        if (input == null || input.isEmpty()){
            throw new InputException("Input is null or empty");
        }

        List<Integer> resultList = new ArrayList<>();
        for (String character: input.split("")){
            resultList.add(Integer.valueOf(character));
        }

        return resultList;
    }

    public List<Integer> convertToUniqueCharacterList(List<Integer> input) throws InputException {

        if (input == null || input.isEmpty()){
            throw new InputException("Input is empty or null");
        }

        List<Integer> resultList = new ArrayList<>();
        for (Integer key: input){
            if (resultList.contains(key)){
                continue;
            }
            resultList.add(key);
        }

        return resultList;
    }

    public long get2HighestNumbers(List<Integer> input) throws InputException {

        if (input == null || input.isEmpty()){
            throw new InputException("Input is null or size is null");
        }
        if (input.size() < 2 ){
            throw new InputException("Inputsize is less the 2");
        }

        long highestNumber = 0;

        for(int i = 0; i< input.size(); i++) {

            int baseNumber = input.get(i);

            for (int y = i + 1; y< input.size(); y++){
                int nextNumber = input.get(y);

                long combinedNumber = Long.parseLong("" + baseNumber + nextNumber);
                if (combinedNumber > highestNumber){
                    highestNumber = combinedNumber;
                }
            }

        }

        return highestNumber;
    }
}
