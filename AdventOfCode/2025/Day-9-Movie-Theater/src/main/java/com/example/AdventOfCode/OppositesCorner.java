package com.example.AdventOfCode;

import java.util.List;

public record OppositesCorner(RedTile one, RedTile two) {

    public long calculateRectangle() {
        AreaCalculator areaCalculator = new AreaCalculator();
        return areaCalculator.calculateRectangle(one,two);
    }

    public boolean containsRedTile(List<RedTile> redTileList) {
        RedTile leftTop = one;
        RedTile rightBottom = two;
        RedTile leftBottom = new RedTile(leftTop.getX(),rightBottom.getY());
        RedTile rightTop = new RedTile(rightBottom.getX(),leftTop.getY());

        for (RedTile current : redTileList) {
            int insideSquareCount = 0;

            if ( (current.getX() > leftTop.getX()) & (current.getY() > leftTop.getY()) ) {
                insideSquareCount++;
            }

            if ( (current.getX() < rightTop.getX()) & (current.getY() > rightTop.getY()) ) {
                insideSquareCount++;
            }

            if ( (current.getX() < rightBottom.getX()) & (current.getY() < rightBottom.getY()) ) {
                insideSquareCount++;
            }

            if ( (current.getX() > leftBottom.getX()) & (current.getY() < rightBottom.getY()) ) {
                insideSquareCount++;
            }
            System.out.println(insideSquareCount);
            if (insideSquareCount == 4){
                return true;
            }
        }
        return false;
    }
}
