package com.example.AdventOfCode;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IntegerParserTest{

    private Parser sutParser;

    @BeforeEach
    public void setup(){
        this.sutParser = new Parser();
    }

    private static Stream<Arguments> inputForTestParseLine(){
        return Stream.of(
            Arguments.of("3 4", 3,4),
            Arguments.of("2 5", 2,5),
            Arguments.of("3     4" , 3,4)
        );
    }

    @ParameterizedTest
    @MethodSource("inputForTestParseLine")
    void testParseLine(String line,int left, int right){
        // Arrange
        Parser.intPairRecord expected = new Parser.intPairRecord(left, right);

        // Act
        Parser.intPairRecord result = sutParser.parseLine(line);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testEmptyUserInput(){
        // Arrange
        String line = "";
        Parser.intPairRecord expected = new Parser.intPairRecord(3, 4);

        // Assert
        assertThrows(InvalidInputException.class, () -> {
            sutParser.parseLine(line);});
    }

    @Test
    void testAssertExceptionLine(){
        // Arrange
        String line = "";
        Parser.intPairRecord expected = new Parser.intPairRecord(3, 4);

        // Assert
        String exceptie = Assertions.assertThrows(InvalidInputException.class, () -> sutParser.parseLine(line)).getMessage();
        assertEquals("empty String", exceptie);
    }

    @Test
    void testInputOneInteger(){
        // Arrange
        String line = "25";
        Parser sutParser = new Parser();

        // Assert
        String exceptie = Assertions.assertThrows(NumberFormatException.class, () -> this.sutParser.parseLine(line)).getMessage();
        assertEquals("Geen 2 input waarde gevonden", exceptie);
    }

    private static Stream<Arguments> provideInvalidInput(){
        return Stream.of(Arguments.of("","empty String"));
    }

    @ParameterizedTest
    @MethodSource("provideInvalidInput")
    void invalidInputTest(String input,String exceptionMessage){
        Exception e = Assertions.assertThrows(InvalidInputException.class, () -> this.sutParser.parseLine(input));

        assertEquals(e.getMessage(),exceptionMessage);
    }


}