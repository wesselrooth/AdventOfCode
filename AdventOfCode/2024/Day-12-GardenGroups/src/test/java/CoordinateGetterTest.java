import com.example.AdventOfCode.CoordinateCalculator;
import com.example.AdventOfCode.Plot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CoordinateGetterTest {

    @Test
    void test_CoordinatesConstructor(){
        // Arrange + Act
        CoordinateCalculator coordinateGetter = new CoordinateCalculator(List.of(List.of("")));

        // Assert
        assertNotNull(coordinateGetter);
    }

    @Test
    void testSingleCoordinate(){
        // Arrange
        List<List<String>> areaList = List.of(List.of("R"));
        CoordinateCalculator coordinateGetter = new CoordinateCalculator(areaList);

        String expected = "0:0";

        // Act
        List<Plot> resultMap = coordinateGetter.getCoordinatesOfLetter();
        String result = resultMap.get(0).getCoordinateString();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testDoubleCoordinateOfOneLeter(){
        // Arrange
        List<List<String>> areaList = List.of(List.of("R","R"));
        CoordinateCalculator coordinateGetter = new CoordinateCalculator(areaList);

        String expected = "1:0";

        // Act
        List<Plot> resultMap = coordinateGetter.getCoordinatesOfLetter();
        String result = resultMap.get(1).getCoordinateString();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testCoordinateGetter_GetSecondRowCoordinate(){
        // Arrange
        List<List<String>> areaList = List.of(List.of("A"),List.of("B"));
        CoordinateCalculator coordinateGetter = new CoordinateCalculator(areaList);

        String expected = "0:1";

        // Act
        List<Plot> resultMap = coordinateGetter.getCoordinatesOfLetter();
        String result = resultMap.get(1).getCoordinateString();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testCoordinateGetter_GetThirdRowCoordinate(){
        // Arrange
        List<List<String>> areaList = List.of(List.of("A"),List.of("B"),List.of("C"));
        CoordinateCalculator coordinateGetter = new CoordinateCalculator(areaList);

        String expected = "0:2";

        // Act
        List<Plot> resultMap = coordinateGetter.getCoordinatesOfLetter();
        String result = resultMap.get(2).getCoordinateString();

        // Assert
        assertEquals(expected,result);
    }
    @Test
    void testCoordinateGetter_GetCoordinateOfThirdColumn(){
        // Arrange
        List<List<String>> areaList = List.of(List.of("A"),List.of("B","B","B"),List.of("C"));
        CoordinateCalculator coordinateGetter = new CoordinateCalculator(areaList);

        String expected = "2:1";

        // Act
        List<Plot> resultMap = coordinateGetter.getCoordinatesOfLetter();
        String result = resultMap.get(3).getCoordinateString();

        // Assert
        assertEquals(expected,result);
    }
    @Test
    void testCoordinateGetter_GetCoordinateLetterInDifferentRow(){
        // Arrange
        List<List<String>> areaList = List.of(List.of("A"),List.of("B","B","C"),List.of("C"));
        CoordinateCalculator coordinateGetter = new CoordinateCalculator(areaList);

        String expected = "2:1";

        // Act
        List<Plot> resultMap = coordinateGetter.getCoordinatesOfLetter();

        // Assert
        assertTrue(resultMap.stream().anyMatch( (Plot p) -> p.getCoordinateString().equals(expected)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0:0","1:1","1:2"})
    void testCoordinateGetter_GetCoordinateInThreeDifferentRows(String expected){
        // Arrange
        List<List<String>> areaList = List.of(List.of("A"),List.of("B","A"),List.of("C","A"));
        CoordinateCalculator coordinateGetter = new CoordinateCalculator(areaList);

        // Act
        List<Plot> resultMap = coordinateGetter.getCoordinatesOfLetter();
        

        // Assert
        assertTrue(resultMap.stream().anyMatch( (Plot p) -> p.getCoordinateString().equals(expected)));
    }
}