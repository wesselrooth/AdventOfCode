package com.example.AdventOfCode;

import java.util.List;

public class DistanceCalculator {

    public static int absoulteDistance(int left, int right){
        return Math.abs(left - right);
    }

    public static int calculateTotalDistance(List<Integer> leftList, List<Integer>rightList ){
        int totalDistance = 0;
        for (int i = 0; i < leftList.size(); i++) {
            int left = leftList.get(i);
            int right = rightList.get(i);

            totalDistance += absoulteDistance(left,right);
        }

        return totalDistance;
    }
}
