package com.example.AdventOfCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Formattable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GridManagerTest {

    @ParameterizedTest
    @CsvSource({
            "@,true",
            ".@,true",
            ".@.,true",
    })
    void isIconAccessibleForForkLift(String input, boolean expected) {
        // Arrange
        InputHelper inputHelper = new InputHelper();
        Grid grid = inputHelper.convertInputToGrid(List.of(input));
        GridManager gridManager = new GridManager();
        int rolIndex = input.indexOf("@");
        Icon icon = new Icon("@",rolIndex,0);

        // Act
        boolean result = gridManager.isRollAccessilbeForForkLift(grid,icon,2);

        // Assert
        assertTrue(result);
    }
}