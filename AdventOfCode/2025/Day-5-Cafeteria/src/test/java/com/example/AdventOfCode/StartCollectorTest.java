package com.example.AdventOfCode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class StartCollectorTest {

    @ParameterizedTest
    @CsvSource({
            "test-input,3",
            "puzzle-input,525"
    })
    void testPartOne(String filename,long expected) throws URISyntaxException, IOException {
        // Arrange
        StartCollector startCollector = new StartCollector();

        // Act
        long result = startCollector.partOne_DetectAmountOfFreshIds(filename);

        // Assert
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource({
            "test-input,14",
            "puzzle-input,525"
    })
    void testPartTwo(String filename,long expected) throws URISyntaxException, IOException {
        // Arrange
        StartCollector startCollector = new StartCollector();

        // Act
        long result = startCollector.partTwo_CalculateAllFreshIds(filename);

        // Assert
        assertEquals(expected,result);
    }

}