package com.example.AdventOfCode;

import com.example.AdventOfCode.helper.InputLoader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class OppositesCornerTest {

    @Test
    void isNotEligible() {
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

        RedTile leftTop = new RedTile(7,0);
        RedTile rightBottom = new RedTile(11,6);

        OppositesCorner rectangele = new OppositesCorner(leftTop,rightBottom);

        // Act + Assert
        assertTrue(rectangele.containsRedTile(redTileList));
    }
}