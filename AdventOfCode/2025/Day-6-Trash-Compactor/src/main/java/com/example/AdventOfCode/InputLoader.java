package com.example.AdventOfCode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class InputLoader {

    public Grid convertInputToGrid(String filename) throws URISyntaxException, IOException {
        Path inputFile = Paths.get(
                InputLoader.class.getClassLoader().getResource(filename).toURI()
        );
        Grid grid = new Grid();
        try (Stream<String> lines = Files.lines(inputFile)){

            for(String line: (Iterable<String>) lines::iterator ){
                if (line.isBlank() || line.isEmpty()){
                    continue;
                }
                Row row = new Row();
                List<String> rowItems = Arrays.stream(line.split("")).toList();
                row.setRowContent(rowItems);

                grid.addRow(row);
            }
        }
        return grid;
    }



}
