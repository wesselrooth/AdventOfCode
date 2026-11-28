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

            if ( (current.getX() >= leftTop().getX()) & (current.getY() >= leftTop().getY()) ) {
                insideSquareCount++;
            }

            if ( (current.getX() <= rightTop().getX()) & (current.getY() >= rightTop().getY()) ) {
                insideSquareCount++;
            }

            if ( (current.getX() <= rightBottom().getX()) & (current.getY() <= rightBottom().getY()) ) {
                insideSquareCount++;
            }

            if ( (current.getX() >= leftBottom().getX()) & (current.getY() <= rightBottom().getY()) ) {
                insideSquareCount++;
            }

            if (insideSquareCount == 4){
                return true;
            }
        }
        return false;
    }

    public boolean isOnConnectingLines(RedTile point) {
        if (onTopLine(point)) {
            return true;
        }
        if (onBottomLine(point)) {
            return true;
        }
        if (onLeftLine(point)) {
            return true;
        }
        if (onRightLine(point)) {
            return true;
        }
        return false;
    }

    private boolean onTopLine (RedTile point) {
        return point.getY() == leftTop().getY() && point.getY() == rightTop().getY() && point.getX() >= leftTop().getX() && point.getX() <= rightTop().getX();
    }

    private boolean onBottomLine(RedTile point) {
        return point.getY() == leftBottom().getY() && point.getY() == rightBottom().getY() && point.getX() >= leftBottom().getX() &&  point.getX() <= rightBottom().getX();
    }

    private boolean onLeftLine(RedTile point) {
        return point.getX() == leftTop().getX() && point.getX() == leftBottom().getX() && point.getY() >= leftTop().getY() && point.getY() <= leftBottom().getY();
    }

    private boolean onRightLine(RedTile point) {
        return point.getX() == rightTop().getX() && point.getX() == rightBottom().getX() && point.getY() >= rightTop().getY() && point.getY() <= rightBottom().getY();
    }

}
