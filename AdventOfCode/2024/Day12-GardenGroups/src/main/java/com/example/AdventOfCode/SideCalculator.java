package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class SideCalculator {

    public Integer calculateSides(Region region){

        List<Plot> plotList = region.getPlotList();

        for (Plot plot: plotList) {
            findConnectingTopSides(region, plot, plotList);
            findConnectingBottomSides(region, plot, plotList);
            findConnectingLeftSides(region, plot, plotList);
            findConnectingRightSides(region, plot, plotList);

        }

        return region.getTotalSides();
    }

    private static void findConnectingRightSides(Region region, Plot plot, List<Plot> plotList) {
        if (!plot.isRightChecked()){

            String rightBorderCheckString = (plot.getX() + 1) + ":" + plot.getY();
            if (!expectedCellExists(plotList, rightBorderCheckString)){
                getSideParts(plot, plotList,Side.RIGHT);
                region.addRightSide();
            }
            plot.setRightChecked(true);
        }
    }

    private static void findConnectingLeftSides(Region region, Plot plot, List<Plot> plotList) {
        if (!plot.isLeftChecked()){
            String leftBorderCheckString = (plot.getX() - 1) + ":" + plot.getY();
            if (!expectedCellExists(plotList, leftBorderCheckString)){
                getSideParts(plot, plotList,Side.LEFT);
                region.addLeftSide();
            }
            plot.setLeftChecked(true);
        }
    }

    private static void findConnectingBottomSides(Region region, Plot plot, List<Plot> plotList) {
        // Bottom
        if (!plot.isBottomChecked()){
            String bottomBorderCheckString = plot.getX() + ":" + (plot.getY() + 1);
            if (!expectedCellExists(plotList, bottomBorderCheckString)){
                getSideParts(plot, plotList,Side.BOTTOM);
                region.addBottomSide();
            }
            plot.setBottomChecked(true);

        }
    }

    private static void findConnectingTopSides(Region region, Plot plot, List<Plot> plotList) {
        // Top
        if (!plot.isTopChecked()){
            String topBorderCheckString = plot.getX() + ":" + (plot.getY() - 1);
            if (!expectedCellExists(plotList, topBorderCheckString)){
                getSideParts(plot, plotList,Side.TOP);
                region.addTopSides();
            }
            plot.setTopChecked(true);
        }
    }

    private static List<Plot> getSideParts(Plot plot, List<Plot> plotList, Side side) {
        List<Plot> resultList = new ArrayList<>();

        switch (side){
            case TOP -> getConnectingTopParts(plot, plotList, resultList);
            case BOTTOM -> getConnectingBottomParts(plot, plotList, resultList);
            case RIGHT -> getConnectingRightParts(plot, plotList, resultList);
            case LEFT ->getConnectingLeftParts(plot, plotList, resultList);
        }
        return resultList;
    }

    private static boolean expectedCellExists(List<Plot> totalPlotList, String expectedCelCoordinate) {

        boolean result = false;

        for (Plot plot: totalPlotList) {
            if (expectedCelCoordinate.equals(plot.getCoordinateString())){
                return true;
            }
        }

        return result;
    }

    private static void getConnectingTopParts(Plot current, List<Plot> plotList, List<Plot> resultList) {
        for (Plot plot: plotList) {

            if (plot.isTopChecked()){
                continue;
            }

            // cannot have the same top
            if (current.getX() == plot.getX()){
                continue;
            }

            // different height
            if (current.getY() != plot.getY()){
                continue;
            }

            // not neighbours
            int xDistance = Math.abs(current.getX() - plot.getX());
            if (xDistance > 1){
                continue;
            }

            String expectedCoordinate = plot.getX() + ":" + (plot.getY() - 1);
            if (expectedCellExists(plotList, expectedCoordinate)){
                continue;
            }

            plot.setTopChecked(true);
            resultList.add(plot);
            getConnectingTopParts(plot,plotList,resultList);

        }
    }

    private static void getConnectingBottomParts(Plot current, List<Plot> plotList, List<Plot> resultList) {
        for (Plot plot: plotList){

            if (plot.isBottomChecked()){
                continue;
            }

            // cannot have the same top
            if (current.getX() == plot.getX()){
                continue;
            }

            // different height
            if (current.getY() != plot.getY()){
                continue;
            }

            // not neighbours
            int xDistance = Math.abs(current.getX() - plot.getX());
            if (xDistance > 1){
                continue;
            }

            String bottomBorderCheckString = plot.getX() + ":" + (plot.getY() + 1);
            if (expectedCellExists(plotList, bottomBorderCheckString)){
                continue;
            }

            plot.setBottomChecked(true);
            resultList.add(plot);
            getConnectingBottomParts(plot,plotList,resultList);
        }
    }

    private static void getConnectingRightParts(Plot current, List<Plot> plotList, List<Plot> resultList) {
        for (Plot plot: plotList){

            if (plot.isRightChecked()){
                continue;
            }

            // cannot have the same to
            if (current.getY() == plot.getY()){
                continue;
            }

            // different height
            if (current.getX() != plot.getX()){
                continue;
            }

            // not neighbours
            int yDistance = Math.abs(plot.getY() - current.getY());
            if (yDistance > 1){
                continue;
            }

            String rightBorderCheckString = (plot.getX() + 1) + ":" + plot.getY();
            if (expectedCellExists(plotList, rightBorderCheckString)){
                continue;
            }

            plot.setRightChecked(true);
            resultList.add(plot);
            getConnectingRightParts(plot,plotList,resultList);

        }
    }
    private static void getConnectingLeftParts(Plot current, List<Plot> plotList, List<Plot> resultList) {
        for (Plot plot: plotList){

            if (plot.isLeftChecked()){
                continue;
            }

            // cannot have the same to
            if (current.getY() == plot.getY()){
                continue;
            }

            // different height
            if (current.getX() != plot.getX()){
                continue;
            }

            // not neighbours
            int yDistance = Math.abs(plot.getY() - current.getY());
            if (yDistance > 1){
                continue;
            }

            String leftBorderCheckString = (plot.getX() - 1) + ":" + plot.getY();
            if (expectedCellExists(plotList, leftBorderCheckString)){
                continue;
            }

            plot.setLeftChecked(true);
            resultList.add(plot);
            getConnectingLeftParts(plot,plotList,resultList);

        }
    }

}
