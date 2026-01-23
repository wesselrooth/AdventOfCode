
import java.util.List;

import com.example.AdventOfCode.IdValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


public class IdValidatorTest {

    @Test
    void constructorTest(){
        // Arrange
        IdValidator idValidator = new IdValidator();
        // Act + Assert
        assertNotNull(idValidator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"11","12341234","1212"})
    void testValidateInvalidIds(String input){
        // Arrange
        IdValidator idValidator = new IdValidator();
        
        // Act
        boolean result = idValidator.validateId(input);

        // Assert
        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12","13","4","10","100","123","444","12345"})
    void validateCorrectInput(String input){
        // Arrange
        IdValidator idValidator = new IdValidator();

        // Act
        boolean result = idValidator.validateId(input);

        // Assert
        assertTrue(result);
    }

    @Test
    void validateIdRangeWith2InvalidID(){
        // Arrange
        IdValidator idValidator = new IdValidator();
        int expected = 11;
        int expected2 = 22;
        // Act
        List<Long> resultList = idValidator.getInvalidIdsInRange(11L,22L);

        // Assert
        assertEquals(expected,resultList.get(0));
        assertEquals(expected2,resultList.get(1));
    }

    @ParameterizedTest
    @CsvSource({
            "95,115,99",
            "998,1012,1010",
            "1188511880,1188511890,1188511885",
            "222220,222224,222222",
            "446443,446449,446446",
            "38593856,38593862,38593859",
    })
    void validateIdRange(long begin,long end, long expected){
        // Arrange
        IdValidator idValidator = new IdValidator();

        // Act
        List<Long> resultList = idValidator.getInvalidIdsInRange(begin,end);

        // Assert
        assertEquals(expected,resultList.get(0));
    }

    @Test
    void testNoInvalidIdInRange(){
        // Arrange
        IdValidator idValidator = new IdValidator();
        int expected = 0;

        // Act
        int resultListLength = idValidator.getInvalidIdsInRange(1698522L,1698528L).size();

        // Assert
        assertEquals(expected,resultListLength);
    }

    @Test
    void testSumInvalidIds(){
        // Arrange
        String input = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124";
        List<String> rangeIds = List.of(input.split(","));

        // Act

        // Assert
    }

}
