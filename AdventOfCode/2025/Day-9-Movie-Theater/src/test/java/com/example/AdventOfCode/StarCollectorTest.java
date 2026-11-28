package com.example.AdventOfCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class StarCollectorTest {

    @ParameterizedTest
    @CsvSource({
            "test-input, 50",
            "puzzle-input, 4752484112"
    })
    void partOne(String filename, long expected) throws IOException, URISyntaxException {
        // Arrange
        StarCollector starCollector = new StarCollector();

        // Act
        long result = starCollector.partOne(filename);

        // Assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "test-input, 24",
            "puzzle-input, 0"
    })
    void partTwo(String filename, long expected) throws IOException, URISyntaxException {
        // Arrange
        StarCollector starCollector = new StarCollector();

        // Act
        long result = starCollector.partTwo(filename);

        // Assert
        assertEquals(expected, result);
    }
}