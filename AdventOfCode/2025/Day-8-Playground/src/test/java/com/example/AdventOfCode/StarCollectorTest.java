package com.example.AdventOfCode;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class StarCollectorTest {

    @Test
    void testPartOne_testInputValue() throws URISyntaxException, IOException {
        // Arrange
        StarCollector starCollector = new StarCollector();
        long expected = 40;

        // Act
        long result = starCollector.partOne("test-input",10);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testPartOne() throws URISyntaxException, IOException {
        // Arrange
        StarCollector starCollector = new StarCollector();
        long expected = 57970;

        // Act
        long result = starCollector.partOne("puzzle-input",1000);

        // Assert
        assertEquals(expected,result);
    }
}