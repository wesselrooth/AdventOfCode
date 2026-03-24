package com.example.AdventOfCode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JoltageHelperTest {

    @ParameterizedTest
    @CsvSource({
            "12,12",
            "123,23"
    })
    void testGetJoltage() {
        // Arrange
        JoltageInterfaceImpl joltageInterfaceImpl = new JoltageInterfaceImpl();


        // Act

        // Assert
    }
}