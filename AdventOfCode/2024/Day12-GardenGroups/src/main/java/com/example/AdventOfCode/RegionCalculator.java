package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegionCalculator {

    private final HashMap<String, Integer> regionIdentifierCount  = new HashMap<>();

    public Map<String,Region> calculateRegions(List<Plot> totalplotList){

        Map<String,Region> regionMap = new HashMap<>();

        Region region = null;

        for (Plot plot : totalplotList) {

            if (plot.isChecked()) {
                continue;
            }

            List<Plot> plotRegion = calculatePlotRegion(plot, totalplotList);
            
            plot.setChecked(true);
            if (plotRegion.isEmpty() ) {
                plotRegion.add(plot);
            }

            region = new Region(plot.getLetter());
            Integer regionId = regionIdentifierCount.get(plot.getLetter());

            if (regionId == null) {
                region.setId(0);    
                regionIdentifierCount.put(plot.getLetter(), 0);
            }else{
                regionId++;
                region.setId(regionId);
                regionIdentifierCount.put(plot.getLetter(), regionId);
            }

            
            region.addAllPlots(plotRegion);
            regionMap.put(region.getIdString(), region);

        }

        return regionMap;
    }

    public List<Plot> calculatePlotRegion(Plot plotToCheck, List<Plot> totalPlotList){

        List<Plot> regionPlots = new ArrayList<>();
        dfs(plotToCheck, totalPlotList, regionPlots);

        return regionPlots;
    }

    private void dfs(Plot current, List<Plot> totalPlotList, List<Plot> resultList) {
        for (Plot plot : totalPlotList) {
            if (plot.isChecked()){
                continue;
            }
            if (validatePlot(current, plot)) continue;

            plot.setChecked(true);
            resultList.add(plot);
            dfs(plot, totalPlotList, resultList);
        }
    }

    private static boolean validatePlot(Plot current, Plot plot) {
        if (haveSameLetter(current, plot)) {
            return true;
        }

        if (isItself(current, plot)) {
            return true;
        }

        if (plot.isChecked()) {
            return true;
        }

        if (!shareBorder(plot, current)) {
            return true;
        }
        return false;
    }

    private static boolean haveSameLetter(Plot current, Plot plot) {
        return !current.getLetter().equals(plot.getLetter());
    }

    private static boolean isItself(Plot currentPlot, Plot plot){
        return currentPlot.getCoordinateString().equals(plot.getCoordinateString());
    }


    public static boolean shareBorder(Plot one, Plot two){

        int xDistance = Math.abs(one.getX() - two.getX());
        int yDistance = Math.abs(one.getY() - two.getY());

        if (xDistance > 1){
            return false;
        }

        if (yDistance > 1){
            return false;
        }

        if (xDistance + yDistance >= 2){
            return false;
        }

        return true;

    }

}
