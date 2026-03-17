package com.example.AdventOfCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CircuitManagerTest {

    @Test
    void constructorTest() {
        // Arrange + Act
        CircuitManager circuitManager = new CircuitManager();
        // Assert
        assertNotNull(circuitManager);
    }

    @ParameterizedTest
    @CsvSource({
            "'',###,true",
            ".,###,true",
            "..,###,true",
            "...,###,false",
            "...,.###,true",
            "....,###,false",
            ".....,.###.,false"
    })
    void testSpriteTouchesToDrawPixel(String circuitString,String sprite,boolean expected){
        // Arrange
        CircuitManager circuitManager = new CircuitManager();

        // Act
        boolean result = circuitManager.spriteTouchesPixelToDraw(circuitString,sprite);

        // Assert
        assertEquals(expected, result);

    }

    @ParameterizedTest
    @CsvSource({
            "true,#,##",
            "true,##,###",
            "false,#.,#..",
            "false,...,....",
            "true,...,...#",
    })
    void drawPixel(boolean touchesSprite,String crt, String expected){
        // Arrange
        CircuitManager circuitManager = new CircuitManager();

        // Act
        String result = circuitManager.updateCircuit(touchesSprite,crt);

        // Assert
        assertEquals(expected,result);
    }
}