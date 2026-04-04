package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.InputException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class JoltageInterfaceImplTest {

    @ParameterizedTest
    @CsvSource({
            "12,12",
            "123,23",
            "132,32",
            "133,33",
            "321,32",
            "312,32",
            "313,33",
            "987654321111111,98",
            "811111111111119,89",
            "234234234234278,78",
            "818181911112111,92",
            "111,11",
    })
    void testGetJoltage(String input,long expected) throws InputException {
        // Arrange
        JoltageFactory joltageInterface = new JoltageFactory();

        // Act
        long  result = joltageInterface.getJoltage(input);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void StringHelperTest_isNull(){
        // Arrange
        JoltageFactory joltageInterface = new JoltageFactory();
        String expected = "Input is null or size is null";

        // Act
        String result = assertThrows(InputException.class, () -> joltageInterface.getJoltage(null)).getMessage();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void StringHelperTest_isEmpty(){
        // Arrange
        JoltageFactory joltageInterface = new JoltageFactory();
        String expected = "Input is null or size is null";

        // Act
        String result = assertThrows(InputException.class, () -> joltageInterface.getJoltage("")).getMessage();

        // Assert
        assertEquals(expected,result);
    }
}