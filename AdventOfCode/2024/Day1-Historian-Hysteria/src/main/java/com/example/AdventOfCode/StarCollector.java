package com.example.AdventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StarCollector {

    public static void main(String[] args) {
        Parser parser = new Parser();
        LocationIdsParser locationIdsParser = new LocationIdsParser(parser);
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get("src/main/resources/input.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // TODO extraheren naar een apparte methode. op deze manier is de code niet te unit-testen.
        // Op een later moment variabelen aanmaken
        ListPairCollection.ListPair listPair = locationIdsParser.parse(lines).sort();

        int result = DistanceCalculator.calculateTotalDistance(listPair.left(),listPair.right());

        int similarityScore = SimilralityScoreCalculator.calculateSimularityScore(listPair.left(),listPair.right());
        System.out.println(similarityScore);
        System.out.println(result);
    }
}
