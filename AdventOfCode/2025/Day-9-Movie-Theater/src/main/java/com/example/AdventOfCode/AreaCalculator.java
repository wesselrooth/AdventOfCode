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

    public List<Rectangle> generateRectangleList(List<RedTile> redTileList) {

        if (redTileList == null || redTileList.isEmpty()) {
            throw new InputException("Input list is empty");
        }

        if (redTileList.size() == 1) {
            throw new InputException("Cannot create pairs of given one RedTile");
        }

        List<Rectangle> rectangleList = new ArrayList<>();
        for (int i = 0; i < redTileList.size(); i++) {
            RedTile current  = redTileList.get(i);
            for (int j = i + 1; j < redTileList.size(); j++) {
                RedTile toCalculate = redTileList.get(j);
                rectangleList.add(new Rectangle(current, toCalculate,null,null));
            }
        }
        return rectangleList;
    }

    public List<Rectangle> filterElligableRectangles(List<Rectangle> inputList, List<RedTile> redTileList) {
        List<Rectangle> resultList = new ArrayList<>();

        for (Rectangle rectangle : inputList) {

            if (rectangle.containsRedTile(redTileList)) {
                continue;
            }
            resultList.add(rectangle);
        }

        return  resultList;
    }

    public boolean redTileIsOnGreenTileLine(RedTile point, List<RedTile> redTileList) {

        for(RedTile current : redTileList) {
            RedTile next = current.getNextRedTile();

            if (onSameHorizontalLine(point,current,next)) {
                return true;
            }

            if (onSameVerticalLine(point,current,next)) {
                return true;
            }
        }
        return false;
    }

    private boolean onSameHorizontalLine(RedTile point, RedTile current, RedTile next){
        if (point.getY() != next.getY()){
            return false;
        }
        return (point.getX() >= current.getX() || point.getX() <= next.getX()) || (point.getX() <= current.getX() || point.getX() >= next.getX());
    }

    private boolean onSameVerticalLine(RedTile point, RedTile current, RedTile next){
        if (point.getX() != next.getX()){
            return false;
        }
        return ((point.getY() >= current.getY() || point.getY() <= next.getY()) || (point.getY() <= current.getY() || point.getY() >= next.getY()));
    }
}
