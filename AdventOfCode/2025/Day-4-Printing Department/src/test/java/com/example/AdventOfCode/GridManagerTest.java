package com.example.AdventOfCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GridManagerTest {

    @ParameterizedTest
    @CsvSource({
            "@,true",
            ".@,true",
            ".@.,true",
    })
    void isRollAccessibleLeftAndRight(String input, boolean expected) {
        // Arrange
        InputHelper inputHelper = new InputHelper();
        Grid grid = inputHelper.convertInputToGrid(List.of(input));
        GridManager gridManager = new GridManager();
        int rolIndex = input.indexOf("@");
        Icon icon = new Icon("@",rolIndex,0);

        // Act
        boolean result = gridManager.isRollAccessibleForForkLift(grid,icon,2);

        // Assert
        assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({
            "1,0,1,false",
            "1,0,2,false",
            "1,0,3,false",
            "1,0,4,true",
            "0,1,0,false",
            "0,1,1,false",
            "0,1,2,false",
            "0,1,3,false",
            "0,1,4,true",
            "1,1,0,false",
            "1,1,1,false",
            "1,1,2,false",
            "1,1,3,false",
            "1,1,4,false",
            "2,1,0,false",
            "2,1,1,false",
            "2,1,2,false",
            "2,1,3,false",
            "2,1,4,true",
            "1,2,0,false",
            "1,2,1,false",
            "1,2,2,false",
            "1,2,3,false",
            "1,2,4,true",
    })
    void testDetectAdjectiveLimitLeftRightAboveAndBelow(int x, int y, int adjectLimit, boolean expected){
        // Arrange
        List<String> inputList = List.of(
                ".@.",
                "@@@",
                ".@.");
        InputHelper inputHelper = new InputHelper();
        Grid grid = inputHelper.convertInputToGrid(inputList);
        Icon iconToCheck = new Icon("@",x,y);
        GridManager gridManager = new GridManager();

        // Act
        boolean result = gridManager.isRollAccessibleForForkLift(grid,iconToCheck,adjectLimit);

        // Assert
        assertEquals(expected,result);
    }


    @Test
    void changeRollToCros() {
        // Arrange
        GridManager gridManager = new GridManager();
        InputHelper inputHelper = new InputHelper();
        Row row = inputHelper.convertInputToGrid(List.of(".@.")).getRows().get(0);
        Icon icon = new Icon("@",1,0);
        String expected = ".X.";

        // Act
        Row resultRow = gridManager.changeRollToCross(row,icon);

        // Assert
        String resultString = "";
        for (Icon resultIcon: resultRow.getRowContent()){
            resultString += resultIcon.getSymbol();
        }
        assertEquals(expected,resultString);
    }
}