package com.example.AdventOfCode;
import com.example.AdventOfCode.helper.InputLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    private Rectangle rectangle;

    @BeforeEach
    void setUp() {
        RedTile leftTop = new RedTile(1, 1);
        RedTile rightTop = new RedTile(5, 1);
        RedTile rightBottom = new RedTile(5, 5);
        RedTile leftBottom = new RedTile(1, 5);

        rectangle = new Rectangle(
                leftTop,
                rightBottom,
                rightTop,
                leftBottom
        );
    }

    @ParameterizedTest
    @MethodSource("pointsOnRectangle")
    void shouldReturnTrueWhenPointIsOnRectangleLine(RedTile point) {
//        RedTile point = new RedTile(x,y);

        assertTrue(rectangle.isOnConnectingLines(point));
    }

    static Stream<RedTile> pointsOnRectangle() {
        return Stream.of(
                new RedTile(3, 1), // Top
                new RedTile(5, 3), // Right
                new RedTile(3, 5), // Bottom
                new RedTile(1, 3), // Left
                new RedTile(1, 1), // Left top corner
                new RedTile(5, 1), // Right top corner
                new RedTile(5, 5), // Right bottom corner
                new RedTile(1, 5)  // Left bottom corner
        );
    }

    @ParameterizedTest
    @MethodSource("pointsNotOnRectangle")
    void shouldReturnFalseWhenPointIsNotOnRectangleLine(RedTile point) {
        assertFalse(rectangle.isOnConnectingLines(point));
    }

    static Stream<RedTile> pointsNotOnRectangle() {
        return Stream.of(
                new RedTile(3, 3), // Inside
                new RedTile(0, 3), // Left outside
                new RedTile(6, 3), // Right outside
                new RedTile(3, 0), // Above
                new RedTile(3, 6)  // Below
        );
    }

    @ParameterizedTest
    @CsvSource({"7,0,11,6",
                "2,3,11,6",
                "7,3,11,6",
                "2,4,11,0",
    })
    void containsRedTile(int x,int y,int x2,int y2) {
        // Arrange
        List<String> inputList = List.of(
                ".......#XXX#..",
                ".......X...X..",
                "..#XXXX#...X..",
                "..X........X..",
                "..#XXXXXX#.X..",
                ".........X.X..",
                ".........#X#..");
        InputLoader inputLoader = new InputLoader();
        List<RedTile> redTileList= inputLoader.loadInputToRedTileList(inputList);

        RedTile leftTop = new RedTile(x,y);
        RedTile rightBottom = new RedTile(x2,y2);

        Rectangle rectangle = new Rectangle(leftTop,rightBottom);

        // Act + Assert
        assertTrue(rectangle.containsRedTile(redTileList));
    }

    @ParameterizedTest
    @MethodSource("pointsInsideRectangle")
    void shouldReturnTrueWhenPointIsInsideRectangle(RedTile point) {
        assertTrue(rectangle.containsRedTile(point));
    }

    static Stream<RedTile> pointsInsideRectangle() {
        return Stream.of(
                new RedTile(2, 2),
                new RedTile(3, 3),
                new RedTile(4, 4),
                new RedTile(2, 4),
                new RedTile(4, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("pointsOutsideRectangle")
    void shouldReturnFalseWhenPointIsOutsideRectangle(RedTile point) {
        assertFalse(rectangle.containsRedTile(point));
    }

    static Stream<RedTile> pointsOutsideRectangle() {
        return Stream.of(
                new RedTile(0, 3), // Left
                new RedTile(6, 3), // Right
                new RedTile(3, 0), // Above
                new RedTile(3, 6), // Below
                new RedTile(0, 0), // Top left
                new RedTile(6, 6)  // Bottom right
        );
    }
}