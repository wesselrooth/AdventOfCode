package com.example.AdventOfCode;

import com.example.AdventOfCode.DistanceCalculator;
import com.example.AdventOfCode.ListPairCollection;
import com.example.AdventOfCode.LocationIdsParser;

import com.example.AdventOfCode.Parser;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LocationIdsParserTest {

    @Test
    void parseListTest(){
//        Arrange
        LocationIdsParser locationIdsParser = new LocationIdsParser(new Parser());
        List<String> inputString = new LinkedList<>();

        ListPairCollection.ListPair expected = new ListPairCollection.ListPair(new ArrayList<>(),new ArrayList<>());
//        Act
        ListPairCollection.ListPair uitkomst = locationIdsParser.parse(inputString);
//        Assert
        assertEquals(expected.left().size(), uitkomst.left().size());
    }

    @Test
    void parseListInput(){
//        Arrange
        Parser parser = mock(Parser.class);

        when(parser.parseLine(anyString())).thenReturn(new Parser.intPairRecord(4,4));

        LocationIdsParser locationIdsParser = new LocationIdsParser(parser);

        List<String> inputString = List.of("4 4", "4 4");

        ListPairCollection.ListPair expected = new ListPairCollection.ListPair(List.of(4,4),List.of(4,4));
//        Act
        ListPairCollection.ListPair result = locationIdsParser.parse(inputString);
//        Assert
        assertEquals(expected,result);
    }

/*
    Rage
 */
    @Test
    void mockParserTest(){
//        Arrange
        Parser mockParser = mock(Parser.class);
        when(
                mockParser.parseLine(anyString())
        ).thenReturn(new Parser.intPairRecord(1,1));

        ListPairCollection.ListPair expected = new ListPairCollection.ListPair(List.of(1,1),List.of(1,1));

        List<String> inputString = List.of("1 1", "1 1");
        LocationIdsParser locationIdsParser = new LocationIdsParser(mockParser);

//        Act
        ListPairCollection.ListPair result = locationIdsParser.parse(inputString);

//        Assert
        assertEquals(expected,result);
    }

    @Test
    void calculateAbsoluteDistance(){
//        Arrang
        List<String> input = List.of("10   -10");
        Parser parser = new Parser();
        int expected = 20;
        LocationIdsParser locationIdsParser = new LocationIdsParser(parser);
        DistanceCalculator distanceCalculator = new DistanceCalculator();
//        Act
        ListPairCollection.ListPair listPair = locationIdsParser.parse(input);
        int left = listPair.left().get(0);
        int right = listPair.right().get(0);
        int absoluteDistance = distanceCalculator.absoulteDistance(left,right);
//        Assert
        assertEquals(expected,absoluteDistance);
    }



}
