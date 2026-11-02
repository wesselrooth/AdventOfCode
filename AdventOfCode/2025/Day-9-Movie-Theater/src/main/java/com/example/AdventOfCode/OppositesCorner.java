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
        RedTile leftBottom = new RedTile(leftTop.x(),rightBottom.y());
        RedTile rightTop = new RedTile(rightBottom.x(),leftTop.y());

        for (RedTile current : redTileList) {
            int insideSquareCount = 0;

            if ( (current.x() > leftTop.x()) & (current.y() > leftTop.y()) ) {
                insideSquareCount++;
            }

            if ( (current.x() < rightTop.x()) & (current.y() > rightTop.y()) ) {
                insideSquareCount++;
            }

            if ( (current.x() < rightBottom.x()) & (current.y() < rightBottom.y()) ) {
                insideSquareCount++;
            }

            if ( (current.x() > leftBottom.x()) & (current.y() < rightBottom.y()) ) {
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
