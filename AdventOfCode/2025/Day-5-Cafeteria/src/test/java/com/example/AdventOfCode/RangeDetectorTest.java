package com.example.AdventOfCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RangeDetectorTest {

    @Test
    void testRange(){
        // Arrange + Act
        RangeDetector rangeDetector = new RangeDetector(new ArrayList<>());

        // Assert
        assertNotNull(rangeDetector);
    }

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

}