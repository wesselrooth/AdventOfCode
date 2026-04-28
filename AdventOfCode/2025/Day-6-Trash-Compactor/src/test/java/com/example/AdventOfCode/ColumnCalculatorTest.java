package com.example.AdventOfCode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColumnCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "1,1,1,*,1",
            "1,1,1,+,3",
            "0,0,1,+,1",
            "1,2,3,*,6",
            "1,2,3,+,6",
            "1,2,3,+,6",
            "0,0,0,+,0",
            "0,0,0,*,0",
            "-1,0,0,*,0",
            "-1,0,0,+,-1",
            "-1,-1,-1,+,-3",
            "-1,-1,-1,*,-1",
            "-1,-1,-2,*,-2",
            "-1,2,3,*,-6",
            "-1,2,-3,*,6",
    })
    void calculateColumnOutput(long number1, long number2, long number3, String oparent, long expected) {
        // Arrange
        Collumn collumn = new Collumn();
        collumn.setNumberList(List.of(number1,number2,number3));
        collumn.setOparent(oparent);
        ColumnCalculator columnCalculator = new ColumnCalculator();

        // Act
        long result = columnCalculator.calculateColumnOutput(collumn);

        // Assert
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource({
            "!",
            "@",
            "/",
            "/",
            "%",
            "&",
            "^",
            "''",
    })
    void testIllegalInput(String oparent) {
        // Arrange
        ColumnCalculator columnCalculator = new ColumnCalculator();
        Collumn collumn = new Collumn();
        collumn.setOparent(oparent);
        String expected = "Unexpected value: %s".formatted(oparent);

        // Act
        String message = assertThrows(IllegalArgumentException.class, () -> columnCalculator.calculateColumnOutput(collumn)).getMessage();

        // Assert
        assertEquals(expected,message);
    }
}