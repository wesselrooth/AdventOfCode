import com.example.AdventOfCode.CoordinateCalculator;
import com.example.AdventOfCode.Plot;
import com.example.AdventOfCode.Region;
import com.example.AdventOfCode.RegionCalculator;
import com.example.AdventOfCode.SideCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SideCalculatorTest {

    @Test
    void singlePlotSideCalculator(){
        // Arrange
        SideCalculator sideCalculator = new SideCalculator();
        List<Plot> plotList = List.of(
                new Plot("A",0,0)
        );
        Region region = new Region("A");
        region.addAllPlots(plotList);
        int expected = 4;

        // Act
        int result = sideCalculator.calculateSides(region);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_doublePlotSideCalculator(){
        // Arrange
        SideCalculator sideCalculator = new SideCalculator();
        Region region = new Region("A");

        region.addAllPlots(
                List.of(
                        new Plot("A",0,0),
                        new Plot("A",1,0)
                )
        );

        int expected = 4;

        // Act
        int result = sideCalculator.calculateSides(region);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_triplePlotSideCalculator(){
        // Arrange
        SideCalculator sideCalculator = new SideCalculator();
        List<Plot> plotList = List.of(
                new Plot("A",0,0),
                new Plot("A",1,0),
                new Plot("A",2,0)
        );
        Region region = new Region("A");
        region.addAllPlots(plotList);
        int expected = 4;

        // Act
        int result = sideCalculator.calculateSides(region);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_sideOfNineSquareRegion(){
        // Arrange
        SideCalculator sideCalculator = new SideCalculator();

        List<Plot> plotList = List.of(
                new Plot("A",0,0),
                new Plot("A",1,0),
                new Plot("A",2,0),

                new Plot("A",0,1),
                new Plot("A",1,1),
                new Plot("A",2,1),

                new Plot("A",0,2),
                new Plot("A",1,2),
                new Plot("A",2,2)
        );

        Region region = new Region("");
        region.addAllPlots(plotList);

        int expected = 4;

        // Act
        int result = sideCalculator.calculateSides(region);
        

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void testCalculateTwoPlotTopSides() {
        // Arrange
        Region region = new Region("A");

        region.addAllPlots(
                List.of(
                        new Plot("A",0,0),
                        new Plot("A",1,0)
                )
        );

        int expected = 1;
        SideCalculator sideCalculator = new SideCalculator();

        // Act
        sideCalculator.calculateSides(region);
        int result = region.getTopSides();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testCalculateTwoPlotBottomSides() {
        // Arrange
        Region region = new Region("A");

        region.addAllPlots(
                List.of(
                        new Plot("A",0,0),
                        new Plot("A",1,0)
                )
        );

        int expected = 1;
        SideCalculator sideCalculator = new SideCalculator();

        // Act
        sideCalculator.calculateSides(region);
        int result = region.getTopSides();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testCalculateTwoPlotLeftSides() {
        // Arrange
        Region region = new Region("A");

        region.addAllPlots(
                List.of(
                        new Plot("A",0,0),
                        new Plot("A",1,0)
                )
        );

        int expected = 1;
        SideCalculator sideCalculator  = new SideCalculator();

        // Act
        sideCalculator.calculateSides(region);
        int result = region.getLeftSides();


        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testCalculateTwoPlotRightSides() {
        // Arrange
        Region region = new Region("A");

        region.addAllPlots(
                List.of(
                        new Plot("A",0,0),
                        new Plot("A",1,0)
                )
        );

        int expected = 1;

        SideCalculator sideCalculator = new SideCalculator();


        // Act
        sideCalculator.calculateSides(region);
        int result = region.getLeftSides();


        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testCalculateSidesOfCornerRegion() {
        // Arrange
        Region region = new Region("A");

        region.addAllPlots(
                List.of(
                        new Plot("A",0,0),
                        new Plot("A",1,0),
                        new Plot("A",0,1)

                )
        );

        int expected = 6;
        SideCalculator sideCalculator = new SideCalculator();
        // Act

        int result = sideCalculator.calculateSides(region);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testCalculateTopSidesOfSquareRegion() {
        // Arrange
        Region region = new Region("A");

        region.addAllPlots(
                List.of(
                        new Plot("A",0,0),
                        new Plot("A",1,0),
                        new Plot("A",0,1),
                        new Plot("A",1,1)

                )
        );

        int expected = 1;
        SideCalculator sideCalculator = new SideCalculator();

        // Act
        sideCalculator.calculateSides(region);
        int result = region.getTopSides();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testCalculateBottomSidesOfSquareRegion() {
        // Arrange
        Region region = new Region("A");

        region.addAllPlots(
                List.of(
                        new Plot("A",0,0),
                        new Plot("A",1,0),
                        new Plot("A",0,1),
                        new Plot("A",1,1)
                )
        );

        int expected = 1;
        SideCalculator sideCalculator = new SideCalculator();

        // Act
        sideCalculator.calculateSides(region);
        int result = region.getBottomSides();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testCalculateLeftSidesOfSquareRegion() {
        // Arrange
        Region region = new Region("A");

        region.addAllPlots(
                List.of(
                        new Plot("A",0,0),
                        new Plot("A",1,0),
                        new Plot("A",0,1),
                        new Plot("A",1,1)
                )
        );

        int expected = 1;
        SideCalculator sideCalculator = new SideCalculator();

        // Act
        sideCalculator.calculateSides(region);
        int result = region.getLeftSides();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testCalculateRightSidesOfSquareRegion() {
        // Arrange
        Region region = new Region("A");

        region.addAllPlots(
                List.of(
                        new Plot("A",0,0),
                        new Plot("A",1,0),
                        new Plot("A",0,1),
                        new Plot("A",1,1)
                )
        );

        int expected = 1;
        SideCalculator sideCalculator = new SideCalculator();

        // Act
        sideCalculator.calculateSides(region);
        int result = region.getRightSides();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testSquareLeftSide(){

        // Arrange
        Region region = new Region("B");

        region.addAllPlots(
                List.of(
                        new Plot("B",0,0),
                        new Plot("B",1,0),
                        new Plot("B",0,1),
                        new Plot("B",1,1)
                )
        );

        int expected = 1;
        SideCalculator sideCalculator = new SideCalculator();


        // Act
        sideCalculator.calculateSides(region);
        int result = region.getLeftSides();

        // Assert
        assertEquals(expected, result);
    }
    @Test
    void test_f_shape(){
        // Arrange
        List<List<String>> inputList = new ArrayList<>();
        List<String> inputString = List.of(
                "EEEEE",
                "E",
                "E",
                "E",
                "E"

        );
        int expected = 6;
        for ( String input : inputString) {
            inputList.add(
                    List.of(input.split(""))
            );
        }
        List<Plot> plotList = new CoordinateCalculator(inputList).getCoordinatesOfLetter();
        Map<String, Region> map = new RegionCalculator().calculateRegions(plotList);
        Region region = map.get("E:0");
        SideCalculator sideCalculator = new SideCalculator();
        // Act

        int result = sideCalculator.calculateSides(region);

        // Assert
        assertEquals(expected,result);
    }


    @Test
    void test_C_shape(){
        // Arrange
        List<List<String>> inputList = new ArrayList<>();
        List<String> inputString = List.of(
                "CC",
                "C",
                "CC"

        );
        int expected = 8;
        for ( String input : inputString) {
            inputList.add(
                    List.of(input.split(""))
            );
        }
        List<Plot> plotList = new CoordinateCalculator(inputList).getCoordinatesOfLetter();
        Map<String, Region> map = new RegionCalculator().calculateRegions(plotList);
        Region region = map.get("C:0");
        SideCalculator sideCalculator = new SideCalculator();
        // Act

        int result = sideCalculator.calculateSides(region);

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_x_o_shape(){
        // Arrange
        List<List<String>> inputList = new ArrayList<>();
        List<String> inputString = List.of(
                "OOOOO",
                "OXOXO",
                "OOOOO"
        );
        int expected = 20;

        for ( String input : inputString) {
            inputList.add(
                    List.of(input.split(""))
            );
        }
        List<Plot> plotList = new CoordinateCalculator(inputList).getCoordinatesOfLetter();
        Map<String, Region> map = new RegionCalculator().calculateRegions(plotList);

        SideCalculator sideCalculator = new SideCalculator();

        // Act
        int result =0;
        for (Region region: map.values()){
            result += sideCalculator.calculateSides(region);
        }

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_left_x_o_shape(){
        // Arrange
        List<List<String>> inputList = new ArrayList<>();
        List<String> inputString = List.of(
                "OOOOO",
                "OXOXO",
                "OOOOO",
                "OXOXO"
        );
        int expected = 5;

        for ( String input : inputString) {
            inputList.add(
                    List.of(input.split(""))
            );
        }
        List<Plot> plotList = new CoordinateCalculator(inputList).getCoordinatesOfLetter();
        Map<String, Region> map = new RegionCalculator().calculateRegions(plotList);

        SideCalculator sideCalculator = new SideCalculator();

        // Act
        Region region = map.get("O:0");
        sideCalculator.calculateSides(region);
        int result = region.getLeftSides();

        // Assert
        assertEquals(expected,result);
    }
}
