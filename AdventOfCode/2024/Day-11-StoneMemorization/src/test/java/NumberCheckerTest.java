import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.NumberChecker;

class NumberCheckerTest {

    @Test
    void testNumberZero(){
        // Arrange
        NumberChecker checker = new NumberChecker();
        List<Long> expected = List.of(1L);
        
        // Act 
        List<Long> result = checker.checkNumber(0L);
        
        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testNumberOne(){
        // Arrange
        NumberChecker checker = new NumberChecker();
        List<Long> expected = List.of(2024L);
        // Act 
        List<Long> result = checker.checkNumber(1L);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testNumberTwentyFour(){
        // Arrange
        NumberChecker checker = new NumberChecker();
        List<Long> expected = List.of(20L,24L);
        // Act 
        List<Long> result = checker.checkNumber(2024L);

        // Assert
        assertEquals(expected, result);
    }

      @Test
    void testEvenDigitNumberWithZero(){
        // Arrange
        NumberChecker checker = new NumberChecker();
        List<Long> expected = List.of(20L,00L);
        // Act 
        List<Long> result = checker.checkNumber(2000L);

        // Assert
        assertEquals(expected, result);
    }

}
