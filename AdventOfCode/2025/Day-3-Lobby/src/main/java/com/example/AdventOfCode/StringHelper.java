package com.example.AdventOfCode;

import java.util.*;

public class StringHelper {

    public List<Integer> convertToListOfInteger(String input){

        List<Integer> resultList = new ArrayList<>();
        for (String character: input.split("")){
            resultList.add(Integer.valueOf(character));
        }

        return resultList;
    }


    public List<Integer> convertToUniqueCharacterList(List<Integer> input){

        List<Integer> resultList = new ArrayList<>();

        for (Integer key: input){
            if (resultList.contains(key)){
                continue;
            }
            resultList.add(key);
        }

        return resultList;
    }

    public HighestNumbers get2HighestNumbers(List<Integer> input){

        List<Integer> uniqueCharacterList = convertToUniqueCharacterList(input);



        return null;
    }
}
