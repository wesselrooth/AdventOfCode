package com.example.AdventOfCode.helper;

import com.example.AdventOfCode.RedTile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputLoaderTest {

    private InputLoader inputLoader;

    @BeforeEach
    void setUp() {
        inputLoader = new InputLoader();
    }

    @Test
    void shouldConnectTilesInInputOrder() throws Exception {
        List<RedTile> tiles =
                inputLoader.loadInputToRedTileList("puzzle-input");

        assertSame(tiles.get(1), tiles.get(0).getNextRedTile());
        assertSame(tiles.get(2), tiles.get(1).getNextRedTile());
        assertSame(tiles.get(3), tiles.get(2).getNextRedTile());
    }

    @Test
    void shouldConnectLastTileToFirstTile() throws Exception {
        List<RedTile> tiles =
                inputLoader.loadInputToRedTileList("puzzle-input");

        assertSame(tiles.getFirst(), tiles.getLast().getNextRedTile());
    }
}