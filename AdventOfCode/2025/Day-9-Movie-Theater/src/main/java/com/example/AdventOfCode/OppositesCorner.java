package com.example.AdventOfCode;

import java.util.List;

public record OppositesCorner(RedTile one, RedTile two) {

    public long calculateRectangleSpan() {
        AreaCalculator areaCalculator = new AreaCalculator();
        return areaCalculator.calculateRectangle(one,two);
    }

    public Rectangle createRectanle() {
        RedTile leftTop = one;
        RedTile rightBottom = two;
        RedTile leftBottom = new RedTile(leftTop.getX(),rightBottom.getY());
        RedTile rightTop = new RedTile(rightBottom.getX(),leftTop.getY());
        return new Rectangle(leftTop,rightTop,rightBottom,leftBottom);
    }

    public boolean containsRedTile(List<RedTile> redTileList) {

        Rectangle rectangle = createRectanle();

        for (RedTile current : redTileList) {
            int insideSquareCount = 0;

            if ( (current.getX() > rectangle.leftTop().getX()) & (current.getY() > rectangle.leftTop().getY()) ) {
                insideSquareCount++;
            }

            if ( (current.getX() < rectangle.rightTop().getX()) & (current.getY() > rectangle.rightTop().getY()) ) {
                insideSquareCount++;
            }

            if ( (current.getX() < rectangle.rightBottom().getX()) & (current.getY() < rectangle.rightBottom().getY()) ) {
                insideSquareCount++;
            }

            if ( (current.getX() > rectangle.leftBottom().getX()) & (current.getY() < rectangle.rightBottom().getY()) ) {
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
