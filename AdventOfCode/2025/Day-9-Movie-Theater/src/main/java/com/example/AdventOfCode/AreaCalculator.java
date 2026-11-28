package com.example.AdventOfCode;

import com.example.AdventOfCode.exception.InputException;

import java.util.*;

public class AreaCalculator {

    public long calculateRectangle(RedTile one, RedTile two) {

        if (shareTheSameSpot(one,two)) {
            return 1;
        }

        long xSpan = calculateCoordinateSpan(one.getX(), two.getX());
        long ySpan = calculateCoordinateSpan(one.getY(), two.getY());
        return xSpan * ySpan;
    }

    private boolean shareTheSameSpot(RedTile one, RedTile two) {
        return one.getY() == two.getY() && one.getX() == two.getX();
    }

    private long calculateCoordinateSpan(long one,  long two) {
        long result  = Math.abs(one-two);
        return ++result;
    }

    public List<OppositesCorner> generateOppositeCornerSet(List<RedTile> redTileList) {

        if (redTileList == null || redTileList.isEmpty()) {
            throw new InputException("Input list is empty");
        }

        if (redTileList.size() == 1) {
            throw new InputException("Cannot create pairs of given one RedTile");
        }

        List<OppositesCorner> pairs = new ArrayList<>();
        for (int i = 0; i < redTileList.size(); i++) {
            RedTile current  = redTileList.get(i);
            for (int j = i + 1; j < redTileList.size(); j++) {
                RedTile toCalculate = redTileList.get(j);
                pairs.add(new OppositesCorner(current, toCalculate));
            }
        }
        return pairs;
    }

    public List<OppositesCorner> filterElligableRectangles(List<OppositesCorner> inputList, List<RedTile> redTileList) {
        List<OppositesCorner> resultList = new ArrayList<>();

        for (OppositesCorner rectangle : inputList) {

            if (rectangle.containsRedTile(redTileList)) {
                continue;
            }
            resultList.add(rectangle);

        }

        return  resultList;
    }

}
