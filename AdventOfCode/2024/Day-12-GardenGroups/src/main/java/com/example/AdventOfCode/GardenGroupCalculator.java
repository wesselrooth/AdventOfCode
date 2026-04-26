package com.example.AdventOfCode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class GardenGroupCalculator {

    private SideCalculator sideCalculator = new SideCalculator();
    private InputLoader inputLoader = new InputLoader();
    private RegionCalculator regionCalculator = new RegionCalculator();

    public Integer calculateGardenGroupPrice(String file) throws URISyntaxException, IOException{

        List<List<String>> garderCoordinate = inputLoader.loadInput(file);

        CoordinateCalculator coordinateCalculator = new CoordinateCalculator(garderCoordinate);

        List<Plot> plotLit = coordinateCalculator.getCoordinatesOfLetter();

        Map<String,Region> regionMap = regionCalculator.calculateRegions(plotLit);

        int count = 0;

        for (Region region : regionMap.values()) {
            int sides =  sideCalculator.calculateSides(region);
            int size  = region.getPlotListSize();
            int result = sides * size;
            count += result;

        }


        return count;
    }
}
