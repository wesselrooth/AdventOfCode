package com.example.AdventOfCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringSorterTest {

    @Test
    void constructorTest(){
        // Arrange + Act
        StringHelper stringHelper = new StringHelper();

        // Assert
        assertNotNull(stringHelper);
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,1",
            "11,1,1",
            "12,12,2",
            "112,12,2",
            "21,21,2",
            "123,123,3",
    })
    void StringHelperTest_convertStringToUniqueCharacters(String rawInput, String expectedKeys,int expectedKeyLength){
        // Arrange
        StringHelper helper = new StringHelper();
        List<Integer> input = helper.convertToListOfInteger(rawInput);

        // Act
        List<Integer> resultKeys = helper.convertToUniqueCharacterList(input);

        // Assert
        assertEquals(resultKeys.size(), expectedKeyLength);
        for (Integer key: resultKeys){
            assertTrue(resultKeys.contains(key));
        }
    }

    @ParameterizedTest
    @CsvSource({
            "12,12",
            "122,12",
            "123,23",
            "1234,34",
            "4321,43",
            "321,32",
    })
    void StringHelperTest_get2HighestDigits(){
        // Arrange
        StringHelper helper = new StringHelper();

        // Act


        // Assert
    }

}