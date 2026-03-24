package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.InputException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class StarCollectorTest {

    @Test
    void testPreperationPartOne() throws InputException, URISyntaxException, IOException {
        // Arrange
        StarCollector starCollector = new StarCollector();
        long expected = 357;

        // Act
        long result = starCollector.partOne("part-one-test-input");

        // Assert
        assertEquals(expected,result);
    }
    @Test
    void testPartOne() throws InputException, URISyntaxException, IOException {
        // Arrange
        StarCollector starCollector = new StarCollector();
        long expected = 16993;

        // Act
        long result = starCollector.partOne("puzzle-input");

        // Assert
        assertEquals(expected,result);
    }
}