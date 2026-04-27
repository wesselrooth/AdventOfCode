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
    @Test
    void testRangeOverlapsMultipleRangesAndOneIsAdded() {
        // Arrange
        List<Range> rangeList = List.of(
                new Range(2,3),
                new Range(5,6),
                new Range(1,7),
                new Range(6,8)
        );
        RangeDetector rangeDetector = new RangeDetector(rangeList);
        long expected = 8;

        // Act
        long result = rangeDetector.calculateFreshIds();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testSimpleRangesWithoutOverlap() {
        // Arrange
        List<Range> rangeList = List.of(
                new Range(1, 3),
                new Range(5, 7)
        );
        RangeDetector rangeDetector = new RangeDetector(rangeList);
        long expected = 6;

        // Act
        long result = rangeDetector.calculateFreshIds();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testFirstRangeOverlapsTheSecond() {
        // Arrange
        List<Range> rangeList = List.of(
                new Range(1, 10),
                new Range(3, 5)
        );
        RangeDetector rangeDetector = new RangeDetector(rangeList);
        long expected = 10;

        // Act
        long result = rangeDetector.calculateFreshIds();

        // Assert
        assertEquals(expected,result);
    }
    @Test
    void testPartOverlap() {
        // Arrange
        List<Range> rangeList = List.of(
                new Range(10, 15),
                new Range(12, 20)
        );
        RangeDetector rangeDetector = new RangeDetector(rangeList);
        long expected = 11;

        // Act
        long result = rangeDetector.calculateFreshIds();

        // Assert
        assertEquals(expected,result);
    }
    @Test
    void testChainOverlap() {
        // Arrange
        List<Range> rangeList = List.of(
                new Range(1, 5),
                new Range(4, 8),
                new Range(7, 10)
        );
        RangeDetector rangeDetector = new RangeDetector(rangeList);
        long expected = 10;

        // Act
        long result = rangeDetector.calculateFreshIds();

        // Assert
        assertEquals(expected,result);
    }
    @Test
    void testExactBorder() {
        // Arrange
        List<Range> rangeList = List.of(
                new Range(1, 5),
                new Range(6, 10)
        );
        RangeDetector rangeDetector = new RangeDetector(rangeList);
        long expected = 10;

        // Act
        long result = rangeDetector.calculateFreshIds();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testDoubleRanges() {
        // Arrange
        List<Range> rangeList = List.of(
                new Range(1, 5),
                new Range(1, 5)
        );
        RangeDetector rangeDetector = new RangeDetector(rangeList);
        long expected = 5;

        // Act
        long result = rangeDetector.calculateFreshIds();

        // Assert
        assertEquals(expected,result);
    }
    @Test
    void testPuzzleExample() {
        // Arrange
        List<Range> rangeList = List.of(
                new Range(3, 5),
                new Range(10, 14),
                new Range(16, 20),
                new Range(12, 18)
        );
        RangeDetector rangeDetector = new RangeDetector(rangeList);
        long expected = 14;

        // Act
        long result = rangeDetector.calculateFreshIds();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testWithOneRange() {
        // Arrange
        List<Range> rangeList = List.of(
                new Range(5, 5)

        );
        RangeDetector rangeDetector = new RangeDetector(rangeList);
        long expected = 1;

        // Act
        long result = rangeDetector.calculateFreshIds();

        // Assert
        assertEquals(expected,result);
    }
}