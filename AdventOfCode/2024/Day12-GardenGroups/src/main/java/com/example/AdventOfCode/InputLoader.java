package com.example.AdventOfCode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InputLoader {

    
    public List<List<String>> loadInput(String filename) throws URISyntaxException, IOException{
        
        
        Path inputFile = Paths.get(
            InputLoader.class.getClassLoader().getResource(filename).toURI()
        );

        List<List<String>> resultList = new ArrayList<>();

        try (Stream<String> lines = Files.lines(inputFile)){

            for(String line: (Iterable<String>) lines::iterator ){

                resultList.add(List.of(line.split("")));

            }
        }

        
        
        return resultList;
    }
}
