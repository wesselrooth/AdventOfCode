package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.CycleException;
import com.example.AdventOfCode.exceptions.SpriteException;
import com.example.AdventOfCode.managers.CycleManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CycleManagerTest {

    private static final int spriteRange = 10;

    @Test
    void test_detectCyleType() throws CycleException, SpriteException {
        // Arrange
        long expected = 1;

        // Act
        long result = new Cycle("noop",0,"").getCycleAmount();

        // Assert
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource({
            "'',Empty cycle String",
            "cycleX 1 1,Unexpected amount of Cycles detected",
            "XXX 0,Unknown cycle type detected"
    })
    void test_detectEmptyCycleString(String input, String expected) {

        // Arrange + Act
        String result = assertThrows(CycleException.class, () -> new Cycle(input,0,"")).getMessage();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_detectTwoCycle() throws CycleException, SpriteException {
        // Arrange
        long expected = 2;

        // Act
        long result = new Cycle("addx 0",0,"").getCycleAmount();

        // Assert
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource({
        "1,addx 2,3",
        "1,addx 1,2",
        "1,addx -2,-1",
        "1,addx -1,0",
        "10,addx -20,-10",
        "1,noop,1"
    })
    void test_registerX(int registryX,String input, long expected) throws CycleException, SpriteException {
        // Arrange
        CycleManager cycleManager = new CycleManager(List.of(999L),spriteRange);
        Cycle cycle = new Cycle(input,registryX,"");
        // Act
        long result = cycleManager.performCycle(cycle).getRegisterX();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_countSignalStrengthWithSingle() throws CycleException, SpriteException {
        // Arrange

        CycleManager cycleManager = new CycleManager(List.of(1L),spriteRange);
        List<String> cycleList =  List.of( "addx 1");
        long expected = 1;

        // Act
        long result = cycleManager.calculateSignalStrength(cycleList);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void test_countSignalStrength() throws CycleException, SpriteException {
        // Arrange
        HashMap<Long,Long> cycleIdentifiers = new HashMap<>();
        cycleIdentifiers.put(1L,null);
        cycleIdentifiers.put(2L,null);
        CycleManager cycleManager = new CycleManager(List.of(1L,2L),spriteRange);
        List<String> cycleList =  List.of( "addx 1","noop");
        long expected = 3;

        // Act
        long result = cycleManager.calculateSignalStrength(cycleList);

        // Assert
        assertEquals(expected, result);
    }

}