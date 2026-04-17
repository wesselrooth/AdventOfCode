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

public class InputHelper {

    public List<List<String>> loadInput(String filename) throws URISyntaxException, IOException {

        Path inputFile = Paths.get(
                InputHelper.class.getClassLoader().getResource(filename).toURI()
        );
        List<List<String>> resultList = new ArrayList<>();
        try (Stream<String> lines = Files.lines(inputFile)){
            for(String line: (Iterable<String>) lines::iterator ){
                resultList.add(Arrays.asList(line.split("")));
            }
        }
        return resultList;
    }

    public Grid convertInputToGrid(List<String> input){

        Grid grid = new Grid();
        for (int y = 0; y < input.size(); y++){

            String yString = input.get(y);
            List<String> splitString = Arrays.stream(yString.split("")).toList();

            Row row = new Row();
            for (int x = 0; x< splitString.size(); x++){
                Icon icon = new Icon(splitString.get(x),x,y);
                row.addIcon(icon);
            }
            grid.addRow(row);
        }
        return grid;
    }
}
