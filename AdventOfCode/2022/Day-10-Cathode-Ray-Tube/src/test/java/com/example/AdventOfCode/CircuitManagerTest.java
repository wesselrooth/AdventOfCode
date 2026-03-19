package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.CycleException;
import com.example.AdventOfCode.exceptions.SpriteException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

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

    @ParameterizedTest
    @CsvSource({
            "40,##..##..##..##..##..##..##..##..##..##..",
            "80,###...###...###...###...###...###...###.",
            "120,####....####....####....####....####....",
            "160,#####.....#####.....#####.....#####.....",
            "200,######......######......######......####",
            "240,#######.......#######.......#######....."
    })
    void preparationTest(Long cycleKey, String expected) throws SpriteException, URISyntaxException, IOException, CycleException {
        // Arrange
        CycleManager cycleManager = new CycleManager(List.of(40L,80L,120L,160L,200L,240L),40);
        InputLoader inputLoader = new InputLoader();
        List<String> input = inputLoader.loadInput("test-input");

        // Act
        String result = cycleManager.circuitStrings(input).get(cycleKey);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void lastTest() throws SpriteException, URISyntaxException, IOException, CycleException {
        // Arrange
        List<Long> keys = List.of(40L,80L,120L,160L,200L,240L);
        CycleManager cycleManager = new CycleManager(keys,40);
        InputLoader inputLoader = new InputLoader();
        List<String> input = inputLoader.loadInput("puzzle-input");

        // Act
        Map<Long,String> result= cycleManager.circuitStrings(input);

        // Assert
        for (Long key: keys){
            System.out.println(result.get(key));
        }
    }
}