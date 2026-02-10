package com.example.AdventOfCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EquationManagerTest {

    @Test
    void constructorTest(){
         // Arrange
        EquationManager equationManager = new EquationManager();

        // Act + Assert
        assertNotNull(equationManager);
    }


    private static Stream<Arguments> equationInput(){
        return Stream.of(
                Arguments.of(1,1,"+",2),
                Arguments.of(1,1,"*",1)
        );
    }

    @ParameterizedTest
    @MethodSource("equationInput")
    void testCalculationResult(long left,long right,String operator,long expected) throws OperatorException {
        // Arrange
        EquationManager equationManager = new EquationManager();

        // Act
        long result = equationManager.calculationResult(left,right,operator);

        // Assert
        assertEquals(expected,result);
    }


    @ParameterizedTest
    @ValueSource(strings ={
            "-",
            "/",
            "%",
            "++",
            "--",
            "-=",
            "+=",
            " ",
    })
    void testUnsupportedException(String input){
        // Arrange
        EquationManager equationManager = new EquationManager();

        String expected = "Unsupported operator";

        // Act
        String result = assertThrows(OperatorException.class, () -> equationManager.calculationResult(1,1,input)).getMessage();

        // Assert
        assertEquals(expected,result);
    }

}