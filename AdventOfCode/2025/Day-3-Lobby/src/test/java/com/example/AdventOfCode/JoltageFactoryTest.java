package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.InputException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class JoltageFactoryTest {


    @ParameterizedTest
    @CsvSource({
            "1112,3,112",
            "1113,3,113",
            "111311,3,311",
            "111312,3,312",
            "987654321111111,12,987654321111",
            "811111111111119,12,811111111119",
            "234234234234278,12,434234234278",
            "818181911112111,12,888911112111",
    })
    void JolategeFactorytest_getHighestnumbner(String input,int amount, long expected) throws InputException {
        // Arrange
        JoltageFactory joltageFactory = new JoltageFactory();

        // Act
        long result = joltageFactory.getJoltage(input,amount);

        // Assert
        assertEquals(expected,result);

    }



}