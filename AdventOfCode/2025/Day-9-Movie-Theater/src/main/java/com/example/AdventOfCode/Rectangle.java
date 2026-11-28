package com.example.AdventOfCode;

import java.util.List;

public record Rectangle (RedTile leftTop, RedTile rightBottom, RedTile rightTop, RedTile leftBottom) {

    public Rectangle {
        leftBottom = new RedTile(leftTop.getX(),rightBottom.getY());
        rightTop = new RedTile(rightBottom.getX(),leftTop.getY());
    }

    public long calculateRectangleSpan() {
        AreaCalculator areaCalculator = new AreaCalculator();
        return areaCalculator.calculateRectangle(leftTop, rightBottom);
    }

    public boolean containsRedTile(List<RedTile> redTileList) {

        for (RedTile current : redTileList) {
            int insideSquareCount = 0;

            if ( (current.getX() > leftTop().getX()) & (current.getY() > leftTop().getY()) ) {
                insideSquareCount++;
            }

            if ( (current.getX() < rightTop().getX()) & (current.getY() > rightTop().getY()) ) {
                insideSquareCount++;
            }

            if ( (current.getX() < rightBottom().getX()) & (current.getY() < rightBottom().getY()) ) {
                insideSquareCount++;
            }

            if ( (current.getX() > leftBottom().getX()) & (current.getY() < rightBottom().getY()) ) {
                insideSquareCount++;
            }

            if (insideSquareCount == 4){
                return true;
            }
        }
        return false;
    }

}
