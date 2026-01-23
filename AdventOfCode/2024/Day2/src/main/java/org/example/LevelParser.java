package org.example;

import java.util.ArrayList;
import java.util.List;

public class LevelParser {
    public static List<String> parseLevel(String input) throws ParceException{

        if (input.isEmpty()){
            throw new ParceException("Input is empty");
        }

        return List.of(input.split("\\s+"));
    }


    public static List<Integer> convertToIntegerList(List<String> inputList){

        List<Integer> integerList = new ArrayList<>();

        for(String value: inputList){
            integerList.add(Integer.valueOf(value));
        }
        return integerList;
    }
}
