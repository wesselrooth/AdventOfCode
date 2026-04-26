import com.example.AdventOfCode.CoordinateCalculator;
import com.example.AdventOfCode.Plot;
import com.example.AdventOfCode.Region;
import com.example.AdventOfCode.RegionCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class RegionCalculatorTest {

    @Test
    void test_getRegions(){
        // Arrange
        List<Plot> plotList = List.of(
                new Plot("A",0,0)
        );
        int expected = 1;
        RegionCalculator regionCalculator = new RegionCalculator();
        Map<String, Region> regionResultMap = regionCalculator.calculateRegions(plotList);

        Region regionResult = regionResultMap.get("A:0");

        // Act
        int result = regionResult.getPlotListSize();

        // Assert
        assertEquals(expected,result);
    }
    

    @Test
    void test_getTwoRegions(){
        // Arrange
        List<Plot> plotList = List.of(
                new Plot("A",0,0),
                new Plot("B",0,0),
                new Plot("B",0,1)
        );

        int expected = 2;
        RegionCalculator regionCalculator = new RegionCalculator();
        Map<String,Region> regionResultMap = regionCalculator.calculateRegions(plotList);
        Region regionResult = regionResultMap.get("B:0");

        // Act
        int result = regionResult.getPlotListSize();

        // Assert
        assertEquals(expected,result);
    }
    
    @Test
    void test_getUniqueRegions(){
        // Arrange
        List<Plot> plotList = List.of(
                new Plot("A",0,0),
                new Plot("B",0,0),
                new Plot("B",0,1),
                new Plot("A",0,4)
        );
        
        int expected = 1;
        RegionCalculator regionCalculator = new RegionCalculator();
        Map<String,Region> regionResultMap = regionCalculator.calculateRegions(plotList);
        Region regionResult = regionResultMap.get("A:1");

        // Act
        int result = regionResult.getPlotListSize();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_getUniqueRegioOfTwoBigRegions(){
        // Arrange
        List<Plot> plotList = List.of(
                new Plot("C",0,0),
                new Plot("C",1,0),
                new Plot("C",2,0),
                new Plot("C",3,0),
                new Plot("C",4,0),
                new Plot("C",0,1),
                new Plot("C",0,2),
                new Plot("C",0,3),
                new Plot("C",0,4),
                new Plot("C",0,5),

                new Plot("A",0,5),
                new Plot("A",1,5),
                new Plot("A",2,5),
                new Plot("A",3,5),
                new Plot("A",4,5),
                new Plot("A",0,6),
                new Plot("A",0,7),
                new Plot("A",0,8),
                new Plot("A",0,9),
                new Plot("A",0,10)
        );

        int expected = 10;
        RegionCalculator regionCalculator = new RegionCalculator();
        Map<String,Region> regionResultMap = regionCalculator.calculateRegions(plotList);
        Region regionResult = regionResultMap.get("A:0");

        // Act
        int result = regionResult.getPlotListSize();

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testUniqueMilitpleRegions(){
        // Arrange
        List<Plot> plotList = List.of(
                new Plot("C",0,0),
                new Plot("C",1,0),
                new Plot("C",2,0),
                new Plot("C",3,0),
                new Plot("C",4,0),

                new Plot("C",0,1),
                new Plot("A",1,1),
                new Plot("C",2,1),
                new Plot("A",3,1),
                new Plot("C",4,1),

                new Plot("C",0,2),
                new Plot("C",1,2),
                new Plot("C",2,2),
                new Plot("C",3,2),
                new Plot("C",4,2)
        );
        RegionCalculator regionCalculator = new RegionCalculator();

        // Act
        Map<String,Region> result = regionCalculator.calculateRegions(plotList);

        // Assert
        assertTrue(result.containsKey("A:0"));
        assertTrue(result.containsKey("A:1"));
        assertTrue(result.containsKey("C:0"));
        assertEquals(3,result.keySet().size());
        assertFalse(result.containsKey("A:2"));

    }

    @Test
    void test_isRegionPresent(){
        // Arrange
        String key = "I:1";
        boolean expected = false;

        List<List<String>> inputList = new ArrayList<>();
        List<String> inputString = List.of(
            "OI",
            "II"
        );

        for ( String input : inputString) {
            inputList.add(
                List.of(input.split(""))
            );
        }
        List<Plot> plotList = new CoordinateCalculator(inputList).getCoordinatesOfLetter();
        
        // Act
        Map<String, Region> map = new RegionCalculator().calculateRegions(plotList);
        // Assert
        
        for (String printKey : map.keySet()) {
            System.out.println(printKey);
        }

        boolean result = map.containsKey(key);
        assertEquals(expected, result);
    }


        static Stream<Arguments> containingKey() {
        return Stream.of(
                Arguments.of("R:0", true),
                Arguments.of("R:1", false),
                Arguments.of("I:0", true),
                Arguments.of("I:1", true)
            
        );
    }

    @Test
    void test_isRegionPresent2(){
        // Arrange
        List<List<String>> inputList = new ArrayList<>();
        List<String> inputString = List.of(
            "XI",
            "II"
        );
        String key = "I:1";
        boolean expected = false;

        for ( String input : inputString) {
            inputList.add(
                List.of(input.split(""))
            );
        }
        List<Plot> plotList = new CoordinateCalculator(inputList).getCoordinatesOfLetter();
        
        // Act
        Map<String, Region> map = new RegionCalculator().calculateRegions(plotList);
        
        // Assert
        boolean result = map.containsKey(key);
        assertEquals(expected, result);
        assertEquals(3, map.get("I:0").getPlotListSize());
    }

    @Test
    void test_isRegionPresent3(){
        // Arrange
        List<List<String>> inputList = new ArrayList<>();
        List<String> inputString = List.of(
            "I",
            "V",
            "I",
            "I"            
        );
        String key = "I:1";
        boolean expected = true;

        for ( String input : inputString) {
            inputList.add(
                List.of(input.split(""))
            );
        }
        List<Plot> plotList = new CoordinateCalculator(inputList).getCoordinatesOfLetter();
        
        // Act
        Map<String, Region> map = new RegionCalculator().calculateRegions(plotList);
        
        // Assert
        for (String printKey : map.keySet()) {
            System.out.println(printKey);
        }

        boolean result = map.containsKey(key);
        assertEquals(expected, result);
    }

    

}
