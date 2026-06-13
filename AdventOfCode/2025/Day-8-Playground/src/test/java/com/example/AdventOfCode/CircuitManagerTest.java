package com.example.AdventOfCode;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxPairs,2);
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
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxPairs,3);
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
        int circuitSizeLength = 1;
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
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxPairs,3);

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

        // Act
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxPairs,0);

        // Assert
        for (Circuit circuit : result) {
            assertEquals(expectedJunctionBoxSize, circuit.getJunctionsBoxes().size());
        }

    }

    @Test
    void twoPairsSameComponent_shouldProduceOneCircuit() {

        CircuitManager manager = new CircuitManager();

        JunctionBox a = new JunctionBox(0, 0, 0);
        JunctionBox b = new JunctionBox(1, 0, 0);
        JunctionBox c = new JunctionBox(2, 0, 0);

        List<JunctionBoxPair> input = List.of(
                new JunctionBoxPair(a, b, 1.0),
                new JunctionBoxPair(b, c, 1.0)
        );

        List<Circuit> result = manager.calculateCircuits(input, input.size());

        assertEquals(1, result.size());
    }

    @Test
    void orderShouldNotMatter() {

        CircuitManager manager = new CircuitManager();

        JunctionBox a = new JunctionBox(0, 0, 0);
        JunctionBox b = new JunctionBox(1, 0, 0);
        JunctionBox c = new JunctionBox(2, 0, 0);

        List<JunctionBoxPair> input1 = List.of(
                new JunctionBoxPair(a, b, 3.0),
                new JunctionBoxPair(b, c, 1.0)
        );

        List<JunctionBoxPair> input2 = List.of(
                new JunctionBoxPair(b, c, 1.0),
                new JunctionBoxPair(a, b, 3.0)
        );

        assertEquals(
                manager.calculateCircuits(input1, 2).size(),
                manager.calculateCircuits(input2, 2).size()
        );
    }

    @Test
    void disconnectedPairs_shouldProduceTwoCircuits() {

        CircuitManager manager = new CircuitManager();

        JunctionBox a = new JunctionBox(0, 0, 0);
        JunctionBox b = new JunctionBox(1, 0, 0);
        JunctionBox c = new JunctionBox(100, 0, 0);
        JunctionBox d = new JunctionBox(101, 0, 0);

        List<JunctionBoxPair> input = List.of(
                new JunctionBoxPair(a, b, 1.0),
                new JunctionBoxPair(c, d, 1.0)
        );

        List<Circuit> result = manager.calculateCircuits(input, input.size());

        assertEquals(2, result.size());
    }
    @Test
    void allNodesShouldEndInSameCircuit() {

        CircuitManager manager = new CircuitManager();

        JunctionBox a = new JunctionBox(0, 0, 0);
        JunctionBox b = new JunctionBox(1, 0, 0);
        JunctionBox c = new JunctionBox(2, 0, 0);
        JunctionBox d = new JunctionBox(3, 0, 0);

        List<JunctionBoxPair> input = List.of(
                new JunctionBoxPair(a, b, 1.0),
                new JunctionBoxPair(b, c, 2.0),
                new JunctionBoxPair(c, d, 3.0)
        );

        List<Circuit> result = manager.calculateCircuits(input, input.size());
        assertEquals(1, result.size());
        Circuit only = result.get(0);
        assertTrue(only.getJunctionsBoxes().containsAll(List.of(a, b, c, d)));
    }
    @Test
    void debugPrintCircuits() throws URISyntaxException, IOException {

        CircuitManager manager = new CircuitManager();

        InputLoader inputLoader = new InputLoader();
        List<JunctionBox> input = inputLoader.loadInput("test-input");
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        List<JunctionBoxPair> pairList = distanceCalculator.calculateJunctionBoxPairDistances(input);
        List<Circuit> result = manager.calculateCircuits(pairList, input.size());

        for (int i = 0; i < result.size(); i++) {
            System.out.println("Circuit " + i + ": " + result.get(i).getJunctionsBoxes());
        }
    }
    @Test
    void diamond_merge_should_create_single_circuit() {

        CircuitManager manager = new CircuitManager();

        JunctionBox a = new JunctionBox(0, 0, 0);
        JunctionBox b = new JunctionBox(1, 0, 0);
        JunctionBox c = new JunctionBox(2, 0, 0);
        JunctionBox d = new JunctionBox(3, 0, 0);

        List<JunctionBoxPair> input = List.of(
                new JunctionBoxPair(a, b, 1.0),
                new JunctionBoxPair(a, c, 1.0),
                new JunctionBoxPair(b, d, 1.0),
                new JunctionBoxPair(c, d, 1.0)
        );

        List<Circuit> result = manager.calculateCircuits(input, input.size());

        assertEquals(1, result.size(),
                "All nodes should collapse into one circuit");
    }



}