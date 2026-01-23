package com.example.AdventOfCode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SimilralityScoreCalculator {

    public int calculateNumberFrequentie(int number, List<Integer> integerList){
        int result = 0;

        for (int i = 0; i < integerList.size(); i++) {

            int indexNumner = integerList.get(i);

            if (number == indexNumner){
                result++;
            }

        }
        return result;
    }

    public List<Integer> getUniqueScoreList(List<Integer> left, List<Integer> right){

        List<Integer> uniqueIntList = new ArrayList<>();

        for (int i = 0; i < left.size(); i++){
            int leftInt = left.get(i);

            if (uniqueIntList.contains(leftInt)){
                continue;
            }

            uniqueIntList.add(leftInt);
        }
        return uniqueIntList;
    }

    public static int calculateSimularityScore(List<Integer> left, List<Integer> right){
        int result = 0;

        HashMap<Integer,Integer> uniqueList = new HashMap<>();

        for (Integer number: left){
            int multiplier = 0;

            for (Integer scoreNumber: right){

                if (!number.equals(scoreNumber)){
                    continue;
                }

                multiplier++;
            }
            System.out.println(number * multiplier);
            result += number * multiplier;

        }

        return result;
    }
}

