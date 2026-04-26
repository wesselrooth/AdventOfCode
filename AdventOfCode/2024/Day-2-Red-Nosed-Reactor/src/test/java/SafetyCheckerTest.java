
import org.example.ParceException;
import org.example.ReportReader;
import org.example.SafetyChecker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SafetyCheckerTest {

    @Test
    void constructorTest(){
    //    Arrange + Act
        SafetyChecker safetyChecker = new SafetyChecker();
    //    Assert
        assertNotNull(safetyChecker);
    }

    @Test
    void reportSafeTest(){
    //    Arrange
        SafetyChecker safetyChecker = new SafetyChecker();
        boolean expected = true;

        List<Integer> integerList = List.of(1,2,3);
    //    Act
        boolean result = safetyChecker.safetyCheck(integerList);
    //    Assert
        assertEquals(expected,result);
    }

    private static Stream<String> unsafeInput(){
        return Stream.of(
                "1 2 7 8 9",
                "9 7 6 2 1",
                "1 1 1 1 1",
                "1 1 2 2",
                "1 2 3 0 5 6 10",
                "4 4 7 9 9 9",
                "4 6 6 3 6"
        );
    }

    @ParameterizedTest
    @MethodSource("unsafeInput")
    void reportUnsafeTest(String input) throws ParceException {
        //    Arrange
        SafetyChecker safetyChecker = new SafetyChecker();
        boolean expexted = false;
        //    Act
        boolean result = ReportReader.reportCheck(input);
        //    Assert
        assertEquals(expexted,result);
    }


    private static Stream<String> safeInput(){
        return Stream.of(
                "7 6 4 2 1 0 -1",
                "1 3 6 7 9",
                "1 3 2 4 5",
                "8 6 4 4 1",
                "1 2 3 4 4",
                "8 7",
                "8 7 6 4 3 1 1",
                "1",
                "1 10 8",
                "1 10 4",
                "2 1 3 4 5"
        );
    }

    @ParameterizedTest
    @MethodSource("safeInput")
    void reportSafeTest(String input) throws ParceException {
        //    Arrange
        boolean expexted = true;
        //    Act
        boolean result = ReportReader.reportCheck(input);
        //    Assert
        assertEquals(expexted,result);
    }
}
