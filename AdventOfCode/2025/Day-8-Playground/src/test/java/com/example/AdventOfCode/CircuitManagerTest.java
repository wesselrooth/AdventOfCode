package com.example.AdventOfCode;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircuitManagerTest {

    @Test
    void circuitManager_testTwoConnectingJunctionBoxes() {
        // Arrange
        CircuitManager circuitManager = new CircuitManager();
        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0,0,0),
                new JunctionBox(0,0,1)
        );
        int expectedLength = 2;

        // Act
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxes);
        Circuit circuit = result.getFirst();

        // Assert
        assertEquals(expectedLength, circuit.getJunctionsBoxes().size());
    }

    @Test
    void circuitManager_testTwoConnectingJunctionBoxesAtTheSameSpot() {
        // Arrange
        CircuitManager circuitManager = new CircuitManager();

        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0,0,0),
                new JunctionBox(0,0,0)
        );
        int expectedLenght = 2;

        // Act
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxes);
        Circuit circuit = result.get(0);

        // Assert
        assertEquals(expectedLenght, circuit.getJunctionsBoxes().size());
    }

    @Test
    void circuitManager_testCreateTwoCircuits() {
        // Arrange
        CircuitManager circuitManager = new CircuitManager();

        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0,0,0),
                new JunctionBox(0,0,1),
                new JunctionBox(0,0,10),
                new JunctionBox(0,0,11)
        );
        int expectedLength = 2;
        // Act
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxes);
        Circuit circuit = result.get(0);
        Circuit circuit2 = result.get(1);

        // Assert
        assertEquals(expectedLength, result.size());
        assertEquals(expectedLength, circuit.getJunctionsBoxes().size());
        assertEquals(expectedLength, circuit2.getJunctionsBoxes().size());
    }

    @Test
    void circuitManager_testDifferentSizeJunctionBoxesSizes() {
        // Arrange
        CircuitManager circuitManager = new CircuitManager();

        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0,0,0),
                new JunctionBox(0,0,1),
                new JunctionBox(0,0,10),
                new JunctionBox(0,0,11),
                new JunctionBox(0,0,12)
        );
        int expectedLength = 3;
        // Act
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxes);
        Circuit circuit2 = result.get(1);

        // Assert
        assertEquals(expectedLength, circuit2.getJunctionsBoxes().size());
    }

    @Test
    void circuitManager_testOneCircuitWithAllPointsAreAtTheSameSpot() {
        // Arrange
        CircuitManager circuitManager = new CircuitManager();

        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0,0,0),
                new JunctionBox(0,0,0),
                new JunctionBox(0,0,0),
                new JunctionBox(0,0,0)
        );
        int expectedLength = 4;
        // Act
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxes);
        Circuit circuit2 = result.getFirst();

        // Assert
        assertEquals(expectedLength, circuit2.getJunctionsBoxes().size());
    }

    @Test
    void circuitManager_testOneCircuitWithNullJunctionBoxes() {
        // Arrange
        CircuitManager circuitManager = new CircuitManager();

        List<JunctionBox> emptyjunctionBoxes = List.of();
        int expectedLength = 0;

        // Act
        List<Circuit> result = circuitManager.calculateCircuits(emptyjunctionBoxes);

        // Assert
        assertEquals(expectedLength, result.size());
    }

    @Test
    void circuitManager_testCircuitWithJunctionBox() {
        // Arrange
        CircuitManager circuitManager = new CircuitManager();

        List<JunctionBox> junctionBoxes = List.of(
                new JunctionBox(0,0,1),
                new JunctionBox(0,0,10),
                new JunctionBox(0,0,11),
                new JunctionBox(0,0,12),
                new JunctionBox(0,0,13)
        );
        int expectedJunctionBoxSize = 5;
        int circuitSizeLength = 1;

        // Act
        List<Circuit> result = circuitManager.calculateCircuits(junctionBoxes);


        // Assert
        Circuit circuit = result.get(0);
        assertEquals(expectedJunctionBoxSize, circuit.getJunctionsBoxes().size());
        assertEquals(circuitSizeLength, result.size());
    }
}