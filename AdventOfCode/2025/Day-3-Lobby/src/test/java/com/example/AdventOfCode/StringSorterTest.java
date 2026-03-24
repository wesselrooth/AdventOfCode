package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.InputException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringSorterTest {

    @ParameterizedTest
    @CsvSource({
            "1,1",
            "11,1",
            "12,2",
            "112,2",
            "21,2",
            "123,3",
    })
    void StringHelperTest_convertToListOfIntegers(String rawInput, int expectedKeyLength) throws InputException {
        // Arrange
        StringHelper helper = new StringHelper();
        List<Integer> input = helper.convertToListOfInteger(rawInput);

        // Act
        List<Integer> resultKeys = helper.convertToUniqueCharacterList(input);

        // Assert
        assertEquals(resultKeys.size(), expectedKeyLength);
    }

    @Test
    void StringHelperTest_EmptyInputTest(){
        // Arrange
        StringHelper helper = new StringHelper();
        String expected = "Input is null or empty";

        // Act
        String result = assertThrows(InputException.class, () -> helper.convertToListOfInteger("")).getMessage();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void StringHelperTest_emptyInput(){
        // Arrange
        StringHelper helper = new StringHelper();
        String expected = "Input is null or size is null";

        // Act
        String result = assertThrows(InputException.class, () -> helper.get2HighestNumbers(null)).getMessage();

        // Assert
        assertEquals(expected,result);
    }
    @Test
    void StringHelperTest_sizeOfZero(){
        // Arrange
        StringHelper helper = new StringHelper();
        String expected = "Input is null or size is null";

        // Act
        String result = assertThrows(InputException.class, () -> helper.get2HighestNumbers(List.of())).getMessage();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void StringHelperTest_isLessThen2(){
        // Arrange
        StringHelper helper = new StringHelper();
        String expected = "Inputsize is less the 2";

        // Act
        String result = assertThrows(InputException.class, () -> helper.get2HighestNumbers(List.of(1))).getMessage();

        // Assert
        assertEquals(expected,result);
    }

}