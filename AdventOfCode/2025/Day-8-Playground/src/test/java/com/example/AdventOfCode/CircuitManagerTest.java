package com.example.AdventOfCode;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircuitManagerTest {

    @Test
    void testCalculateCircuits_TwoConnectingJunctionBoxes() {
        // Arrange
        CircuitManager circuitManager = new CircuitManager();
        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0,0,0),
                new JunctionBox(0,0,1)
        );
        int expectedLength = 2;
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        List<JunctionBoxPair> junctionBoxPairs = distanceCalculator.calculateJunctionBoxPairDistances(junctionBoxes);
        // Act
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxPairs,1);
        Circuit circuit = result.getFirst();

        // Assert
        assertEquals(expectedLength, circuit.getJunctionsBoxes().size());
    }

    @Test
    void testCalculateCircuits_TwoConnectingJunctionBoxesAtTheSameSpot() {
        // Arrange
        CircuitManager circuitManager = new CircuitManager();

        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0,0,0),
                new JunctionBox(0,0,0)
        );
        int expectedLength = 2;

        DistanceCalculator distanceCalculator = new DistanceCalculator();
        List<JunctionBoxPair> junctionBoxPairs = distanceCalculator.calculateJunctionBoxPairDistances(junctionBoxes);

        // Act
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxPairs,1);
        Circuit circuit = result.getFirst();

        // Assert
        assertEquals(expectedLength, circuit.getJunctionsBoxes().size());
    }

    @Test
    void testCalculateCircuits_TestCreateTwoCircuits() {
        // Arrange
        CircuitManager circuitManager = new CircuitManager();

        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0,0,0),
                new JunctionBox(0,0,1),
                new JunctionBox(0,0,10),
                new JunctionBox(0,0,11)
        );
        int expectedLength = 2;
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        List<JunctionBoxPair> junctionBoxPairs = distanceCalculator.calculateJunctionBoxPairDistances(junctionBoxes);

        // Act
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxPairs,4);
        Circuit circuit = result.get(0);
        Circuit circuit2 = result.get(1);

        // Assert
        assertEquals(expectedLength, result.size());
        assertEquals(expectedLength, circuit.getJunctionsBoxes().size());
        assertEquals(expectedLength, circuit2.getJunctionsBoxes().size());
    }

    @Test
    void testCalculateCircuits_DifferentSizeJunctionBoxesSizes() {
        // Arrange
        CircuitManager circuitManager = new CircuitManager();

        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0,0,0),
                new JunctionBox(0,0,1),
                new JunctionBox(0,0,10),
                new JunctionBox(0,0,11),
                new JunctionBox(0,0,12)
        );
        int expectedLength = 2;

        DistanceCalculator distanceCalculator = new DistanceCalculator();
        List<JunctionBoxPair> junctionBoxPairs = distanceCalculator.calculateJunctionBoxPairDistances(junctionBoxes);

        // Act
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxPairs,5);
        Circuit circuit2 = result.getFirst();

        // Assert
        assertEquals(expectedLength, circuit2.getJunctionsBoxes().size());
    }

    @Test
    void testCalculateCircuits_OneCircuitWithAllPointsAreAtTheSameSpot() {
        // Arrange
        CircuitManager circuitManager = new CircuitManager();
        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0,0,0),
                new JunctionBox(0,0,0),
                new JunctionBox(0,0,0),
                new JunctionBox(0,0,0)
        );
        int expectedLength = 4;
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        List<JunctionBoxPair> junctionBoxPairs = distanceCalculator.calculateJunctionBoxPairDistances(junctionBoxes);

        // Act
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxPairs,4);
        Circuit circuit2 = result.getFirst();

        // Assert
        assertEquals(expectedLength, circuit2.getJunctionsBoxes().size());
    }

    @Test
    void testCalculateCircuits_OneCircuitWithNullJunctionBoxes() {
        // Arrange
        CircuitManager circuitManager = new CircuitManager();
        int expectedLength = 0;

        // Act
        List<Circuit> result = circuitManager.calculateCircuits(List.of(),0);

        // Assert
        assertEquals(expectedLength, result.size());
    }

    @Test
    void testCalculateCircuits_CircuitWithJunctionBox() {
        // Arrange
        CircuitManager circuitManager = new CircuitManager();
        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0,0,1),
                new JunctionBox(0,0,10),
                new JunctionBox(0,0,11),
                new JunctionBox(0,0,12),
                new JunctionBox(0,0,13)
        );
        int expectedJunctionBoxSize = 4;
        int circuitSizeLength = 2;
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        List<JunctionBoxPair> junctionBoxPairs = distanceCalculator.calculateJunctionBoxPairDistances(junctionBoxes);

        // Act
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxPairs,5);

        // Assert
        Circuit circuit = result.getFirst();
        assertEquals(expectedJunctionBoxSize, circuit.getJunctionsBoxes().size());
        assertEquals(circuitSizeLength, result.size());
    }

    @Test
    void testCalculateCircuits_CircuitOfThreeJunctionBoxesAndOne() {
        // Arrange
        CircuitManager circuitManager = new CircuitManager();
        JunctionBox expectedJunctionBox = new JunctionBox(0,0,1);
        JunctionBox expectedJunctionBox2 = new JunctionBox(0,0,2);
        JunctionBox expectedJunctionBox3 = new JunctionBox(0,0,3);
        JunctionBox expectedJunctionBox4 = new JunctionBox(0,0,10);

        List<JunctionBox> junctionBoxes = List.of(
                expectedJunctionBox, expectedJunctionBox2, expectedJunctionBox3, expectedJunctionBox4
        );
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        int expectedJunctionBoxSize = 3;

        List<JunctionBoxPair> junctionBoxPairs = distanceCalculator.calculateJunctionBoxPairDistances(junctionBoxes);

        // Act
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxPairs,4);

        // Assert
        Circuit circuit = result.getFirst();
        assertEquals(expectedJunctionBoxSize, circuit.getJunctionsBoxes().size());
    }

    @Test
    void testCalculateCircuits_circuitsWithOneJunctionBox() {
        // Arrange
        CircuitManager circuitManager = new CircuitManager();
        JunctionBox expectedJunctionBox = new JunctionBox(0,0,0);
        JunctionBox expectedJunctionBox2 = new JunctionBox(0,0,1);

        List<JunctionBox> junctionBoxes = List.of(
                expectedJunctionBox, expectedJunctionBox2
        );
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        int expectedJunctionBoxSize = 1;
        List<JunctionBoxPair> junctionBoxPairs = distanceCalculator.calculateJunctionBoxPairDistances(junctionBoxes);

        // Act
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxPairs,0);

        // Assert
        for (Circuit circuit : result) {
            assertEquals(expectedJunctionBoxSize, circuit.getJunctionsBoxes().size());
        }
    }

    @Test
    void testCalculateCircuits_circuitsWithOneJunctionBoxMultipleJunctionBoxes() {
        // Arrange
        CircuitManager circuitManager = new CircuitManager();
        JunctionBox expectedJunctionBox = new JunctionBox(0,0,0);
        JunctionBox expectedJunctionBox2 = new JunctionBox(0,0,1);
        JunctionBox expectedJunctionBox3 = new JunctionBox(0,0,0);
        JunctionBox expectedJunctionBox4 = new JunctionBox(0,0,10);

        List<JunctionBox> junctionBoxes = List.of(
                expectedJunctionBox, expectedJunctionBox2, expectedJunctionBox3, expectedJunctionBox4
        );
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        int expectedJunctionBoxSize = 1;
        List<JunctionBoxPair> junctionBoxPairs = distanceCalculator.calculateJunctionBoxPairDistances(junctionBoxes);
        JunctioBoxHelper junctioBoxHelper = new JunctioBoxHelper();
        List<JunctionBoxPair> sortenList = junctioBoxHelper.sortJunctionBoxPairs(junctionBoxPairs);

        // Act
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxPairs,0);

        // Assert
        for (Circuit circuit : result) {
            assertEquals(expectedJunctionBoxSize, circuit.getJunctionsBoxes().size());
        }

    }
}