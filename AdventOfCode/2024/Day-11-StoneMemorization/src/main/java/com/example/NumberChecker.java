package com.example;

import java.util.List;

public class NumberChecker {

    //Test push
    public List<Long> checkNumber(Long number){
        
        if (number == 0L){
            return List.of(1L);
        }
        String digitString = Long.toString(number);

        int digitCount = digitString.split("").length;

        if (digitCount %2 == 0) {
            
            long left = Long.parseLong(digitString.substring(0, digitCount/2));
            long right = Long.parseLong(digitString.substring(digitCount/2));

            return List.of(left,right);
        }

        return List.of(number * 2024L);
    }
}
