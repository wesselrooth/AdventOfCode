import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.ListChecker;

class StoneListCheckerTest {

    @Test
    void testList(){
        // Arrange
        ListChecker checker = new ListChecker();
        List<Long> expected = List.of(2024L);
        
        // Act
        List<Long> result = checker.checkList(List.of(1L));

        // Assert
        assertEquals(expected, result);
    }
}
