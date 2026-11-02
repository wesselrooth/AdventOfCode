package com.example.AdventOfCode.helper;

import com.example.AdventOfCode.RedTile;
import com.example.AdventOfCode.exception.InputException;

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

    public List<RedTile> loadInputToRedTileList(List<String> redTileList) {
        List<RedTile> list = new ArrayList<>();
        for (int y = 0; y < redTileList.size(); y++) {
            String rawInputString = redTileList.get(y);
            List<String> rawInputStringList = Arrays.asList(rawInputString.split(""));

            for  (int x = 0; x < rawInputStringList.size(); x++) {
                String icon =  rawInputStringList.get(x);

                if (!icon.equals("X") & !icon.equals(".") & !icon.equals("#")) {
                    throw new InputException("Invalid icon");
                }

                if (icon.equals("#")){
                    list.add(new RedTile(x, y));
                }
            }

        }
        return list;
    }

}
