package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Stream;

public class ReportReader {

    public static int count = 0;
    public static int i = 0;
    public static void main(String[] args) throws IOException, URISyntaxException, ParceException {

        Path inputFile = Paths.get(
                ReportReader.class.getClassLoader().getResource("input.txt").toURI()
        );

        try (Stream<String> lines = Files.lines(inputFile)){

            for(String line: (Iterable<String>) lines::iterator ){

                if (reportCheck(line)){
                    count++;
                }
            }
        }

        System.out.println("result: %s".formatted(count));
    }


    public static boolean reportCheck(String input) throws ParceException {

        List<String> stringInput = LevelParser.parseLevel(input);

        List<Integer> integerList = LevelParser.convertToIntegerList(stringInput);

        SafetyChecker safetyChecker = new SafetyChecker();

        return safetyChecker.safetyCheck(integerList);
    }

}
