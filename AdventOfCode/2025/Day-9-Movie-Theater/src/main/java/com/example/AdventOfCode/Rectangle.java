package com.example.AdventOfCode;

import java.util.List;

public record Rectangle (RedTile leftTop, RedTile rightBottom, RedTile rightTop, RedTile leftBottom) {

    public Rectangle(RedTile pointOne, RedTile pointTwo) {
        this(
                new RedTile(
                        Math.min(pointOne.getX(), pointTwo.getX()),
                        Math.min(pointOne.getY(), pointTwo.getY())
                ),
                new RedTile(
                        Math.max(pointOne.getX(), pointTwo.getX()),
                        Math.max(pointOne.getY(), pointTwo.getY())
                ),
                new RedTile(
                        Math.max(pointOne.getX(), pointTwo.getX()),
                        Math.min(pointOne.getY(), pointTwo.getY())
                ),
                new RedTile(
                        Math.min(pointOne.getX(), pointTwo.getX()),
                        Math.max(pointOne.getY(), pointTwo.getY())
                )
        );
    }

    public long calculateRectangleSpan() {
        AreaCalculator areaCalculator = new AreaCalculator();
        return areaCalculator.calculateRectangle(leftTop, rightBottom);
    }

    public boolean containsRedTile(List<RedTile> redTileList) {

        for (RedTile current : redTileList) {
            if (containsRedTile(current)) {
                return true;
            };
        }
        return false;
    }

    public boolean containsRedTile(RedTile current) {
        int insideSquareCount = 0;
        if (current.getX() == 7 && current.getY() == 2) {
            System.out.print("stop");
        }
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

    public boolean pointIsOnGreenTileLine(RedTile point, List<RedTile> redTileList) {

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
