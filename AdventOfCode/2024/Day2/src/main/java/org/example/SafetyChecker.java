package org.example;

import java.util.ArrayList;
import java.util.List;

public class SafetyChecker {




    public boolean safetyCheck (List<Integer> inputList){

        boolean result =  listSafetyChecker(inputList);

        if (!result){

            //Create a copy of the list in case it goes wrong
            for (int i = 0; i < inputList.size(); i++) {
                List<Integer> retryList = new ArrayList<>();

                retryList.addAll(inputList);

                retryList.remove(i);

                if (listSafetyChecker(retryList)){
                    return true;
                }

            }
        }

        return  result;
    }

    public boolean listSafetyChecker(List<Integer> inputList){

        Integer previousNumber = null;

        String previousTrend = "";
        String trend = "";

        for (int i = 0; i < inputList.size(); i++) {

            if (i==0){
                previousNumber = inputList.get(i);
                continue;
            }

            Integer number = inputList.get(i);
            Integer absoluteDistance = Math.abs(number - previousNumber);

            if (absoluteDistance == 0 || absoluteDistance > 3) {
                return false;
            }

            if (number > previousNumber){
                trend = "increase";
            } else {
                trend = "decrease";
            }

            previousNumber = number;

            // if it's the first check between numbers, than there is no before, go to next
            if (previousTrend.isEmpty()){
                previousTrend = trend;
                continue;
            }

            if (!previousTrend.equals(trend)){
                return false;
            }
        }
        return true;
    }
}
