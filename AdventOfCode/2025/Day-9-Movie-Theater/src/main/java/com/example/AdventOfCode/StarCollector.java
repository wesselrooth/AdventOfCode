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
        List<Rectangle> rectangleList = areaCalculator.generateRectangleList(redTileList);

        rectangleList.sort(Comparator.comparingDouble((Rectangle area) -> area.calculateRectangleSpan()).reversed());

        return rectangleList.getFirst().calculateRectangleSpan();
    }

    public long partTwo(String fileName) throws IOException, URISyntaxException {
        final InputLoader loader = new InputLoader();
        final List<RedTile> redTileList = loader.loadInputToRedTileList(fileName);
        final AreaCalculator areaCalculator = new AreaCalculator();
        final List<Rectangle> rectangleList = areaCalculator.generateRectangleList(redTileList);

        int originalRectangleListSize = 0;
        int newRectangleListSize = 0;
        do {
            originalRectangleListSize = rectangleList.size();
            rectangleList.stream().filter(rectangle -> rectangle.containsRedTile(redTileList))
                                  .filter(rectangle -> {
                                      if (!rectangle.pointIsOnGreenTileLine(rectangle.leftTop(), redTileList) || !rectangle.containsRedTile(rectangle.leftTop())) {
                                          return true;
                                      }
                                      if (!rectangle.pointIsOnGreenTileLine(rectangle.rightTop(), redTileList) || !rectangle.containsRedTile(rectangle.rightTop())) {
                                          return true;
                                      }
                                      if (!rectangle.pointIsOnGreenTileLine(rectangle.rightBottom(), redTileList) || !rectangle.containsRedTile(rectangle.rightBottom())) {
                                          return true;
                                      }
                                      if (!rectangle.pointIsOnGreenTileLine(rectangle.leftBottom(), redTileList) || !rectangle.containsRedTile(rectangle.leftBottom())) {
                                          return true;
                                      }
                                      return false;
                                  });
            newRectangleListSize = rectangleList.size();
        }while(originalRectangleListSize != newRectangleListSize);

        rectangleList.sort(Comparator.comparingDouble((Rectangle area) -> area.calculateRectangleSpan()).reversed());

        return rectangleList.getFirst().calculateRectangleSpan();
    }
}
