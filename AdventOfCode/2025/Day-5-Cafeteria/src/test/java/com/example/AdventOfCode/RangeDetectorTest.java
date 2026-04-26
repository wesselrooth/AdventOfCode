package com.example.AdventOfCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RangeDetectorTest {

    @ParameterizedTest
    @CsvSource({
            "0,true",
            "1,true",
            "2,true",
            "3,true",
            "4,false",
    })
    void testRanges(long id, boolean expected){
        // Arrange
        RangeDetector rangeDetector = new RangeDetector(List.of(new Range(0,3)));

        // Act
        boolean result  = rangeDetector.isIdInAnyRange(id);

        // Assert
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource({
            "1,1",
            "2,1",
            "3,1",
            "4,0",
    })
    void detectIfIdIsvalid(long input, long expected){
        // Arrange
        RangeDetector rangeDetector = new RangeDetector(List.of(new Range(0,3)));

        // Act
        long result = rangeDetector.returnFreshIds(List.of(input)).size();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testCalculateFreshIds() {
        // Arrange
        Range range = new Range(3,5);
        RangeDetector rangeDetector = new RangeDetector(List.of(range));
        long expected = 3L;

        // Act
        long result = rangeDetector.calculateFreshIds();

        // Assert
        assertEquals(result,expected);
    }

    @Test
    void testRangeOverlapsMultipleRanges() {
        // Arrange
        List<Range> rangeList = List.of(
                new Range(2,3),
                new Range(5,6),
                new Range(1,7)
        );
        RangeDetector rangeDetector = new RangeDetector(rangeList);
        long expected = 7;

        // Act
        long result = rangeDetector.calculateFreshIds();

        // Assert
        assertEquals(expected,result);
    }
}