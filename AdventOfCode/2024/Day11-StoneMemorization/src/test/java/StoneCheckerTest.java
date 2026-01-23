import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.StoneChecker;

class StoneCheckerTest {
    @Test
    void test6BLinks(){
        // Arrange
        StoneChecker stoneChecker = new StoneChecker(new HashMap<String,Long>());
        long expected = 22L;
        // Act 
        Long result = stoneChecker.blinker(List.of(125L,17L), 6L);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    void test25BLinks(){
        // Arrange
        StoneChecker stoneChecker = new StoneChecker(new HashMap<String,Long>());
        long expected = 55312L;
        // Act
        Long result = stoneChecker.blinker(List.of(125L,17L), 25L);
        // Assert
        assertEquals(expected, result);
    }



}
