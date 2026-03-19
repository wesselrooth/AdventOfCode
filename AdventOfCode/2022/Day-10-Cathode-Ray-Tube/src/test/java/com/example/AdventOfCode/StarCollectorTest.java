package com.example.AdventOfCode;

import com.example.AdventOfCode.exceptions.CycleException;
import com.example.AdventOfCode.exceptions.SpriteException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.*;

class StarCollectorTest {

    @Test
    void test_testInputPartOne() throws CycleException, URISyntaxException, IOException {
        // Arrange
        StarCollector starCollector = new StarCollector();
        long expected = 13140;

        // Act
        long result = starCollector.partOne("test-input");

        // Assert
        assertEquals(expected,result);
    }

    @Test
    void partOne() throws CycleException, URISyntaxException, IOException {
        // Arrange
        StarCollector starCollector = new StarCollector();
        long expected = 17840;

        // Act
        long result = starCollector.partOne("puzzle-input");

        // Assert
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource({
            "40,##..##..##..##..##..##..##..##..##..##..",
            "80,###...###...###...###...###...###...###.",
            "120,####....####....####....####....####....",
            "160,#####.....#####.....#####.....#####.....",
            "200,######......######......######......####",
            "240,#######.......#######.......#######....."
    })
    void partTwoPrepTest(Long cycleKey, String expected) throws SpriteException, URISyntaxException, IOException, CycleException {
        // Arrange
        StarCollector starCollector = new StarCollector();

        // Act
        String result = starCollector.partTwo("test-input").get(cycleKey);

        // Assert
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource({
            "40,####..##..#.....##..#..#.#....###...##..",
            "80,#....#..#.#....#..#.#..#.#....#..#.#.##.",
            "120,###..#..#.#....#....#..#.#....#..#.#....",
            "160,##...####.#....#.##.#..#.#....###..#.##.",
            "200,#....#..#.#....#..#.#..#.#....#....#..#.",
            "240,####.#..#.####..###..##..####.#.....###."
    })
    void partTwo(Long cycleKey, String expected) throws SpriteException, URISyntaxException, IOException, CycleException {
        // Arrange
        StarCollector starCollector = new StarCollector();

        // Act
        String result = starCollector.partTwo("puzzle-input").get(cycleKey);

        // Assert
        assertEquals(expected,result);
    }
}