package com.example.AdventOfCode;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SimulatorScoreCalculatorTest {

    @Test
    void calculateSimularityScore(){
    // Arrange
    SimilralityScoreCalculator simulralityScoreCalculator = new SimilralityScoreCalculator();
    int expected = 1;

    // Act
    assertEquals(expected,simulralityScoreCalculator.calculateNumberFrequentie(2,List.of(1,2)));
    }

    @Test
    void oneTimeMuliplierTest(){
        // Arrange
        SimilralityScoreCalculator simulralityScoreCalculator = new SimilralityScoreCalculator();
        Integer[] expected = {1};

        List<Integer> left = List.of(1);
        List<Integer> right = List.of(1,1,2);
        // Act
        List<Integer> uniqueNumberList = simulralityScoreCalculator.getUniqueScoreList(left,right);
        // Assert
        assertArrayEquals(expected,uniqueNumberList.toArray());
    }

    @Test
    void test_singleCheckOfNumber(){
        // Arrange
        SimilralityScoreCalculator simulralityScoreCalculator = new SimilralityScoreCalculator();
        Integer[] expected = {1};

        List<Integer> left = List.of(1,1);
        List<Integer> right = List.of(1,1,2);
        // Act
        List<Integer> uniqueNumberList = simulralityScoreCalculator.getUniqueScoreList(left,right);
        // Assert
        assertArrayEquals(expected,uniqueNumberList.toArray());
    }

    @Test
    void testCalculateSimilarityScore(){
        // Arrange
        SimilralityScoreCalculator sutSimilatorScoreCalculator = new SimilralityScoreCalculator();
        int expected = 2;
        List<Integer> left = List.of(1);
        List<Integer> right = List.of(1,1,2);

        List<Integer> uniqueList = sutSimilatorScoreCalculator.getUniqueScoreList(left,right);
        // Act
        int result = sutSimilatorScoreCalculator.calculateSimularityScore(uniqueList,right);
        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_CalculateSimularityScore(){
        // Arrange
        SimilralityScoreCalculator sutSimilatorScoreCalculator = new SimilralityScoreCalculator();
        int expected = 6;
        List<Integer> left = List.of(1,2);
        List<Integer> right = List.of(1,1,2,2);

        List<Integer> uniqueList = sutSimilatorScoreCalculator.getUniqueScoreList(left,right);
        // Act
        int result = sutSimilatorScoreCalculator.calculateSimularityScore(uniqueList,right);
        // Assert
        assertEquals(expected,result);
    }

    @Test
    void test_FinalTest(){
        // Arrange
        SimilralityScoreCalculator sutSimilatorScoreCalculator = new SimilralityScoreCalculator();
        int expected = 31;
        List<Integer> left = List.of(3,4,2,1,3,3);
        List<Integer> right = List.of(4,3,5,3,9,3);
        // Act
        int result = sutSimilatorScoreCalculator.calculateSimularityScore(left,right);
        // Assert
        assertEquals(expected,result);
    }

}
