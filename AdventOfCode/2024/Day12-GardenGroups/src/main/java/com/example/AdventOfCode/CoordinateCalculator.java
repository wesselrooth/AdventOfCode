package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;


public class CoordinateCalculator {

    private final List<List<String>> gardenGroups;

    public CoordinateCalculator(List<List<String>> inputList){
        this.gardenGroups = inputList;
    }

    public List<Plot> getCoordinatesOfLetter(){

        List<Plot> plotList = new ArrayList<>();

        for (int row= 0; row < gardenGroups.size(); row++){
            List<String> regionList = gardenGroups.get(row);

            for (int index = 0; index < regionList.size(); index++){

                String letter = regionList.get(index);
                plotList.add(new Plot(letter, index, row));
                
            }
        }

        return plotList;

    }
}
