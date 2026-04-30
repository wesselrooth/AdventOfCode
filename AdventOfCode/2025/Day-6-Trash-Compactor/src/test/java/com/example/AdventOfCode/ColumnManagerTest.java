package com.example.AdventOfCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColumnManagerTest {

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
        ColumnManager columnManager = new ColumnManager();

        // Act
        long result = columnManager.calculateColumnOutput(collumn);

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
        ColumnManager columnManager = new ColumnManager();
        Collumn collumn = new Collumn();
        collumn.setOparent(oparent);
        String expected = "Unexpected value: %s".formatted(oparent);

        // Act
        String message = assertThrows(IllegalArgumentException.class, () -> columnManager.calculateColumnOutput(collumn)).getMessage();

        // Assert
        assertEquals(expected,message);
    }

    @ParameterizedTest
    @CsvSource({
            "1,10,*,#1",
            "1,10,+,1#",
            "1,100,+,1##",
            "1,100,*,##1",
    })
    void padNumbers(String number1, String number2, String oparent, String expected) {
        // Arrange
        Collumn collumn = new Collumn();
        collumn.setNumberStringList(Arrays.asList(number1,number2));
        collumn.setOparent(oparent);
        ColumnManager columnManager = new ColumnManager();

        // Act
        collumn =  columnManager.padNumbers(collumn);
        String paddedNumberResult = collumn.getNumberStringList().get(0);

        // Assert
        assertEquals(expected, paddedNumberResult);
    }
}