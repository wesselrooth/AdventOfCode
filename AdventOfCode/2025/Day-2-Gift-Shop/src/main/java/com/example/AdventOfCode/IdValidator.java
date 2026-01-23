package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class IdValidator {

    public boolean validateId(String input){

        boolean result = false;

        if (input.length() == 1){
            return true;
        }

        if (input.length() % 2 != 0 ){
            return true;
        }


        String firstPart = input.substring(0,input.length() / 2);
        String lastPart = input.substring(input.length() / 2);
        if (firstPart.equals(lastPart)){
            return false;
        }


        return true;
    }

    public List<Long> getInvalidIdsInRange(Long begin, Long end){

        List<Long> resultList = new ArrayList<>();


        for (long i = begin; i <= end; i++){

            String id = String.valueOf(i);

            if (validateId(id)){
                continue;
            }

            resultList.add(i);
        }

        return resultList;
    }


    public Long sumInvalidIds(List<Long> resultList){
        return 0L;
    }
}
