package com.example.AdventOfCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CycleManagerTest {


    @Test
    void test_signalStrengthCycleTime(){
        // Arrange
        CycleManager cycleManager = new CycleManager(List.of(999L));
        long expected = 1;

        // Act
        long result  = cycleManager.signalStrengthCycle(1,1,1);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_signalStrengthCycleTwoTime(){
        // Arrange
        CycleManager cycleManager = new CycleManager(List.of(999L));
        long expected = 2;

        // Act
        long result  = cycleManager.signalStrengthCycle(1,1,2);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_detectCyleType() throws CycleException {
        // Arrange
        CycleManager cycleManager = new CycleManager(List.of(999L));
        long expected = 1;

        // Act
        long result = cycleManager.detectCycleType("noop").getCycleAmount();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_detectEmptyCicleString() {
        // Arrange
        CycleManager cycleManager = new CycleManager(List.of(999L));
        String expected = "Empty cycle String";

        // Act
        String result = assertThrows(CycleException.class, () -> cycleManager.detectCycleType("")).getMessage();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_detectUnexpectedAmountOfCycles() {
        // Arrange
        CycleManager cycleManager = new CycleManager(List.of(999L));
        String expected = "Unexpected amound of Cycles detected";

        // Act
        String result = assertThrows(CycleException.class, () -> cycleManager.detectCycleType("cycleX 1 1")).getMessage();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_detectUnknownCyclePartOne() {
        // Arrange
        CycleManager cycleManager = new CycleManager(List.of(999L));
        String expected = "Unknown cycle type detected";

        // Act
        String result = assertThrows(CycleException.class, () -> cycleManager.detectCycleType("XXX 0")).getMessage();

        // Assert
        assertEquals(expected,result);
    }
    @Test
    void test_detectTwoSignalStrengthCycle() throws CycleException {
        // Arrange
        CycleManager cycleManager = new CycleManager(List.of(999L));
        long expected = 2;

        // Act
        long result = cycleManager.detectCycleType("addx 0").getCycleAmount();

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
    void test_registerXValueAfter3Cycles(int registryX,String cycle, long expected) throws CycleException {
        // Arrange
        CycleManager cycleManager = new CycleManager(List.of(999L));

        // Act
        long result = cycleManager.performCycle(registryX,cycle,true,false);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_countSignalStrengthWithSingle() throws CycleException {
        // Arrange

        CycleManager cycleManager = new CycleManager(List.of(1L));
        List<String> cycleList =  List.of( "addx 1");
        long expected = 1;

        // Act
        long result = cycleManager.calculateSignalStrength(cycleList);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void test_countSignalStrength() throws CycleException {
        // Arrange
        HashMap<Long,Long> cycleIdentifiers = new HashMap<>();
        cycleIdentifiers.put(1L,null);
        cycleIdentifiers.put(2L,null);
        CycleManager cycleManager = new CycleManager(List.of(1L,2L));
        List<String> cycleList =  List.of( "addx 1","noop");
        long expected = 3;

        // Act
        long result = cycleManager.calculateSignalStrength(cycleList);

        // Assert
        assertEquals(expected, result);
    }

}