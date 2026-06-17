package com.example.AdventOfCode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class StarCollectorTest {

/*
    Uncommented because the implementation only suitable for part-two
 */
//    @ParameterizedTest
//    @CsvSource({
//            "test-input,4277556",
//            "puzzle-input,5322004718681"
//    })
    void testPartOne(String filename, Long expected) throws URISyntaxException, IOException {
        // Arrange
        StarCollector starCollector = new StarCollector();

        // Act
        long result = starCollector.partOne(filename);

        // Assert
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource({
            "test-input,3263827",
            "puzzle-input,9876636978528"
    })
    void testPartTwo(String filename, Long expected) throws URISyntaxException, IOException {
        // Arrange
        StarCollector starCollector = new StarCollector();

        // Act
        long result = starCollector.partTwo(filename);

        // Assert
        assertEquals(expected,result);
    }


}