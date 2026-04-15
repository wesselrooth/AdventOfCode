package com.example.AdventOfCode;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanceCalculatorTest {

    // TODO calculate total distance heeft geel gesorteerde lijst nodig.
    // Maak deze test onafhankelijk van andere code.
    // sorteren van deze lijst is ook niet nodig, voor deze test. dit moet een nieuwe test worden.
    @Test
    void calculateTotalDistance(){
//      Arrange
        List<String> input = List.of("3   4","4   3","2   5","1   3","3   9","3   3");
        Parser parser = new Parser();
        int expected = 11;
        LocationIdsParser locationIdsParser = new LocationIdsParser(parser);
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        ListPairCollection.ListPair listPair = locationIdsParser.parse(input).sort();
//      Act
        int result = distanceCalculator.calculateTotalDistance(listPair.left(),listPair.right());
//      Assert
        assertEquals(expected,result);
    }

    

}
