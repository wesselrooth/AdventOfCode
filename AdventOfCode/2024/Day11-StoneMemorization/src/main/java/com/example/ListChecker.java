package com.example;

import java.util.ArrayList;
import java.util.List;

public class ListChecker {

    private static NumberChecker checker = new NumberChecker();

    public static List<Long> checkList(List<Long> inputList){
        List<Long> resultList = new ArrayList<>();
        
        for (Long number : inputList) {
            resultList.addAll(checker.checkNumber(number));
        }

        return resultList;
    }
}
