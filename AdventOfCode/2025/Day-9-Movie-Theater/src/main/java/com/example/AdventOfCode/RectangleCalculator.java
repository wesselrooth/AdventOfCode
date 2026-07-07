package com.example.AdventOfCode;

public class RectangleCalculator {

    public long calculateRectangle(RedTile one, RedTile two) {

        if (shareTheSameSpot(one,two)) {
            return 1;
        }

        long xSpan = calculateCoordinateSpan(one.x(), two.x());
        long ySpan = calculateCoordinateSpan(one.y(), two.y());
        return xSpan * ySpan;
    }

    private boolean shareTheSameSpot(RedTile one, RedTile two) {
        return one.y() == two.y() && one.x() == two.x();
    }

    private long calculateCoordinateSpan(long one,  long two) {
        long result  = Math.abs(one-two);

        return ++result;
    }

}
