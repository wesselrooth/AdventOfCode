package com.example.AdventOfCode.helper;

import com.example.AdventOfCode.RedTile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InputLoader {
    public List<RedTile> loadInputToRedTileList(String filename) throws URISyntaxException, IOException {

        Path inputFile = Paths.get(
                InputLoader.class.getClassLoader().getResource(filename).toURI()
        );

        List<RedTile> redTileList = new ArrayList<>();

        try (Stream<String> lines = Files.lines(inputFile)){

            for(String line: (Iterable<String>) lines::iterator ){

                long x = Long.parseLong(line.split(",")[0]);
                long y = Long.parseLong(line.split(",")[1]);

                RedTile redTile = new RedTile(x,y);
                redTileList.add(redTile);
            }
        }
        return redTileList;
    }
}
