package com.example.AdventOfCode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class OpositesCornerTest {

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
        Rectangle rectangle = new Rectangle(one, two);

        // Act
        long result = rectangle.calculateRectangleSpan();

        // Assert
        assertEquals(expected,result);
    }

}