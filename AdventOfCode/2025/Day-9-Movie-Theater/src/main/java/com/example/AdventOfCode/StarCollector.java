package com.example.AdventOfCode;

import com.example.AdventOfCode.helper.InputLoader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class StarCollector {

    public long partOne(String fileName) throws IOException, URISyntaxException {
        InputLoader loader = new InputLoader();
        List<RedTile> redTileList = loader.loadInputToRedTileList(fileName);

        AreaCalculator areaCalculator = new AreaCalculator();
        List<OppositesCorner> oppositesCornerList = areaCalculator.generateOppositeCornerSet(redTileList);

        oppositesCornerList.sort(Comparator.comparingDouble((OppositesCorner area) -> area.calculateRectangleSpan()).reversed());

        return oppositesCornerList.getFirst().calculateRectangleSpan();
    }

}
