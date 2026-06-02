package com.example.AdventOfCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DistanceCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "0, 0, 0, 0, 0, 0, 0",
            "0, 0, 0, 3, 0, 0, 3",
            "0, 0, 0, 0, 4, 0, 4",
            "0, 0, 0, 0, 0, 5, 5",
            "0, 0, 0, 3, 4, 0, 5",
            "1, 2, 3, 4, 6, 6, 5.830951894845301",
            "-1, -2, -3, -4, -6, -6, 5.830951894845301",
            "-1, 2, -3, 4, -6, 3, 11.180339887498949",
            "10, 20, 30, 40, 50, 60, 51.96152422706632"
    })
    void testCalculateEuclideanDistance(long leftX, long leftY, long leftZ, long rightX, long rightY, long rightZ, double expected) {
        // Arrange
        JunctionBox box1 = new JunctionBox(leftX, leftY, leftZ);
        JunctionBox box2 = new JunctionBox(rightX, rightY, rightZ);
        DistanceCalculator distanceCalculator = new DistanceCalculator();

        // Act
        double result = distanceCalculator.calculateEuclideanDistance(box1,box2);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testCalculateJunctionBoxPairDistance_AtTheSameSpot() {
        // Arrange
        DistanceCalculator distanceCalculator = new DistanceCalculator();

        JunctionBox expectedLeft = new JunctionBox(0,0,0);
        JunctionBox expectedRight = new JunctionBox(0,0,0);

        List<JunctionBox> junctionBoxes = List.of(
                expectedLeft,
                expectedRight
        );

        // Act
        Map<DistanceJunctionBoxCombination,Double> resultMap = distanceCalculator.calculateJunctionBoxPairDistances(junctionBoxes);
        List<Map.Entry<DistanceJunctionBoxCombination, Double>> sortedEntryList = distanceCalculator.sortCollectionOfJunctionBoxCombinationDistances(resultMap);


        // Assert
        DistanceJunctionBoxCombination result = sortedEntryList.getFirst().getKey();
        List<JunctionBox> resultList = List.of(result.left(), result.right());
        assertTrue(resultList.contains(expectedLeft));
        assertTrue(resultList.contains(expectedRight));
    }

    @Test
    void testCalculateJunctionBoxPairDistance_WithSmallDifference() {
        // Arrange
        DistanceCalculator distanceCalculator = new DistanceCalculator();

        JunctionBox expectedLeft = new JunctionBox(0,0,0);
        JunctionBox expectedRight = new JunctionBox(0,0,1);

        List<JunctionBox> junctionBoxes = List.of(
            expectedLeft,
            expectedRight
        );

        // Act
        Map<DistanceJunctionBoxCombination,Double> resultMap = distanceCalculator.calculateJunctionBoxPairDistances(junctionBoxes);
        List<Map.Entry<DistanceJunctionBoxCombination, Double>> sortedEntryList = distanceCalculator.sortCollectionOfJunctionBoxCombinationDistances(resultMap);

        // Assert
        DistanceJunctionBoxCombination result = sortedEntryList.getFirst().getKey();
        List<JunctionBox> resultList = List.of(result.left(), result.right());
        assertTrue(resultList.contains(expectedLeft));
        assertTrue(resultList.contains(expectedRight));
    }

    @Test
    void testCalculateJunctionBoxPairDistance_WithSmallDifferenceOfOne() {
        // Arrange
        DistanceCalculator distanceCalculator = new DistanceCalculator();

        JunctionBox expectedLeft = new JunctionBox(0,0,0);
        JunctionBox expectedRight = new JunctionBox(0,0,1);

        List<JunctionBox> junctionBoxes = List.of(
                expectedLeft,
                expectedRight
        );

        // Act
        DistanceJunctionBoxCombination result = distanceCalculator.calculateJunctionBoxPairDistances(junctionBoxes).entrySet().stream().toList().getFirst().getKey();

        // Assert
        List<JunctionBox> resultList = List.of(result.left(), result.right());
        assertTrue(resultList.contains(expectedLeft));
        assertTrue(resultList.contains(expectedRight));
    }

    @Test
    void testCalculateJunctionBoxPairDistance_InTheMiddleOf2Points() {
        // Arrange
        DistanceCalculator distanceCalculator = new DistanceCalculator();

        JunctionBox expectedLeft = new JunctionBox(0,0,3);
        JunctionBox expectedRight = new JunctionBox(0,0,4);

        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0,0,0),
                expectedLeft,
                expectedRight,
                new JunctionBox(0,0,10)
        );

        // Act
        Map<DistanceJunctionBoxCombination,Double> result = distanceCalculator.calculateJunctionBoxPairDistances(junctionBoxes);
        DistanceJunctionBoxCombination resultCombination = distanceCalculator.sortCollectionOfJunctionBoxCombinationDistances(result).getFirst().getKey();

        // Assert
        List<JunctionBox> resultList = List.of(resultCombination.left(), resultCombination.right());
        assertTrue(resultList.contains(expectedLeft));
        assertTrue(resultList.contains(expectedRight));
    }

    @Test
    void testCalculateClosedJunctionBoxPair_AtTheEdge() {
        // Arrange
        DistanceCalculator distanceCalculator = new DistanceCalculator();

        JunctionBox expectedLeft = new JunctionBox(0,0,7);
        JunctionBox expectedRight = new JunctionBox(0,0,8);

        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0,0,0),
                new JunctionBox(0,0,2),
                expectedLeft,
                expectedRight
        );

        // Act
        Map<DistanceJunctionBoxCombination,Double> result = distanceCalculator.calculateJunctionBoxPairDistances(junctionBoxes);
        DistanceJunctionBoxCombination resultCombination = distanceCalculator.sortCollectionOfJunctionBoxCombinationDistances(result).getFirst().getKey();

        // Assert
        List<JunctionBox> resultList = List.of(resultCombination.left(), resultCombination.right());
        assertTrue(resultList.contains(expectedLeft));
        assertTrue(resultList.contains(expectedRight));
    }

    @Test
    void testCalculateClosedJunctionBoxPair_AtTheEdge2() {
        // Arrange
        DistanceCalculator distanceCalculator = new DistanceCalculator();

        JunctionBox expectedLeft = new JunctionBox(0,0,7);
        JunctionBox expectedRight = new JunctionBox(0,0,8);

        List<JunctionBox> junctionBoxes = List.of(
                expectedLeft,
                expectedRight,
                new JunctionBox(0,0,100),
                new JunctionBox(0,0,200)
        );

        // Act
        Map<DistanceJunctionBoxCombination,Double> result = distanceCalculator.calculateJunctionBoxPairDistances(junctionBoxes);
        DistanceJunctionBoxCombination resultCombination = distanceCalculator.sortCollectionOfJunctionBoxCombinationDistances(result).getFirst().getKey();

        // Assert
        List<JunctionBox> resultList = List.of(resultCombination.left(), resultCombination.right());
        assertTrue(resultList.contains(expectedLeft));
        assertTrue(resultList.contains(expectedRight));
    }

    @Test
    void testCalculateJunctionBoxPairDistance_TwoMostDistantPoints() {
        // Arrange
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        DistanceJunctionBoxCombination expectedDistanceJunctionBoxCombination = new DistanceJunctionBoxCombination(new JunctionBox(0,0,0),new JunctionBox(0,0,1));
        DistanceJunctionBoxCombination distanceJunctionBoxCombination = new DistanceJunctionBoxCombination(new JunctionBox(0,0,10),new JunctionBox(0,0,11));

        List<JunctionBox> junctionBoxes = List.of(
                expectedDistanceJunctionBoxCombination.left(),
                expectedDistanceJunctionBoxCombination.right(),
                distanceJunctionBoxCombination.left(),
                distanceJunctionBoxCombination.right()
        );

        // Act
        Map<DistanceJunctionBoxCombination,Double> result = distanceCalculator.calculateJunctionBoxPairDistances(junctionBoxes);
        DistanceJunctionBoxCombination resultCombination = distanceCalculator.sortCollectionOfJunctionBoxCombinationDistances(result).getFirst().getKey();

        List<JunctionBox> resultList = List.of(resultCombination.left(), resultCombination.right());
        assertTrue(resultList.contains(expectedDistanceJunctionBoxCombination.left()));
        assertTrue(resultList.contains(expectedDistanceJunctionBoxCombination.right()));
    }
}