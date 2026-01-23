package com.example.AdventOfCode;

public class Parser {


    public record intPairRecord(int left, int right) {
    }


    public intPairRecord parseLine(String line) {
    
        if (line.isEmpty()) {
            throw new InvalidInputException("empty String");
        }

        String[] splitArray = line.split("\\s+");

        if (splitArray.length != 2) {
            throw new NumberFormatException("Geen 2 input waarde gevonden");
        }

        int left = Integer.parseInt(splitArray[0]);
        
        int right = Integer.parseInt(splitArray[1]);

        return new intPairRecord(left, right);
    }
}