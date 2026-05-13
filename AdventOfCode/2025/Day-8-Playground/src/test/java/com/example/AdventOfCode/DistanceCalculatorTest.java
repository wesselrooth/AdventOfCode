package com.example.AdventOfCode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DistanceCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "0, 0, 0, 0, 0, 0, 0",
            "0, 0, 0, 3, 0, 0, 3",
            "0, 0, 0, 0, 4, 0, 4",
            "0, 0, 0, 0, 0, 5, 5",
            "0, 0, 0, 3, 4, 0, 5",
            "1, 2, 3, 4, 6, 6, 5.830951894845301",
            "-1, -2, -3, -4, -6, -6, 5.830951894845301",
            "-1, 2, -3, 4, -6, 3, 11.180339887498949",
            "10, 20, 30, 40, 50, 60, 51.96152422706632"
    })
    void calculateEuclideanDistance(long leftX, long leftY, long leftZ, long rightX, long rightY, long rightZ, double expected) {
        // Arrange
        JunctionBox box1 = new JunctionBox(leftX, leftY, leftZ);
        JunctionBox box2 = new JunctionBox(rightX, rightY, rightZ);
        DistanceCalculator distanceCalculator = new DistanceCalculator();

        // Act
        double result = distanceCalculator.calculateEuclideanDistance(box1,box2);

        // Assert
        assertEquals(expected, result);
    }
}