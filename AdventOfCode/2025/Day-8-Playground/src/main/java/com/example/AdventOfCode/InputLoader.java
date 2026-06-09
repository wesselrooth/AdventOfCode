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

import static java.util.Arrays.asList;

public class InputLoader {

    public List<JunctionBox> loadInput(String filename) throws URISyntaxException, IOException {

        Path inputFile = Paths.get(
                InputLoader.class.getClassLoader().getResource(filename).toURI()
        );

        List<JunctionBox> resultList = new ArrayList<>();

        try (Stream<String> lines = Files.lines(inputFile)){

            for(String line: (Iterable<String>) lines::iterator ){
                String[] splittedString = line.split(",");
                long x =  Long.parseLong(splittedString[0]);
                long y =  Long.parseLong(splittedString[1]);
                long z =  Long.parseLong(splittedString[2]);
                resultList.add(new JunctionBox(x,y,z));
            }
        }

        return resultList;
    }


}
