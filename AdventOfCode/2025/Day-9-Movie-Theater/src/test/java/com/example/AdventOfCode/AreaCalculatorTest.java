package com.example.AdventOfCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AreaCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "0,0,0,0,1",
            "0,0,0,1,2",
            "0,0,1,0,2",
            "0,0,1,1,4",
            "1,1,0,0,4",
            "0,0,0,8,9",
            "0,0,0,10,11",
            "0,0,2,10,33",
            "-1,0,2,10,44",
            "-1,-1,0,0,4",
            "-1,-1,0,10,24",
            "-1,-1,1,1,9",
    })
    void calculateRectangle(int x1, int y1, int x2, int y2, long expected) {
        // Arrange
        RedTile one = new RedTile(x1,y1);
        RedTile two = new RedTile(x2,y2);
        AreaCalculator sut = new AreaCalculator();

        // Act
        long result = sut.calculateRectangle(one,two);

        // Assert
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource({
            "2,1",
            "3,3",
            "4,6",
            "5,10",
            "6,15",
            "7,21",
            "8,28",
            "9,36",
            "10,45"
    })
    void generateOppositeCornerSet(int amountOfRedTiles, int expectedPairs) {
        // Arrange
        List<RedTile> redTileList = new ArrayList<>();
        for (int i = 0; i < amountOfRedTiles; i++) {
            redTileList.add(new RedTile(i,i));
        }
        AreaCalculator sut = new AreaCalculator();

        // Act
        int result = sut.generateOpositeCornerSet(redTileList).size();

        // Assert
        assertEquals(expectedPairs,result);

    }
}