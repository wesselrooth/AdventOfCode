package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.CycleException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class StarCollectorTest {

    @Test
    void test_testInputPartOne() throws CycleException, URISyntaxException, IOException {
        // Arrange
        StarCollector starCollector = new StarCollector();
        long expected = 13140;

        // Act
        long result = starCollector.partOne("test-input");

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void partOne() throws CycleException, URISyntaxException, IOException {
        // Arrange
        StarCollector starCollector = new StarCollector();
        long expected = 17840;

        // Act
        long result = starCollector.partOne("puzzle-input");

        // Assert
        assertEquals(expected,result);
    }
}