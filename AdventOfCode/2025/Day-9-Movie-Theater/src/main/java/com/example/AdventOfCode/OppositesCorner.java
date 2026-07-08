package com.example.AdventOfCode;

public record OppositesCorner(RedTile one, RedTile two) {

    public long calculateRectangle() {
        AreaCalculator areaCalculator = new AreaCalculator();
        return areaCalculator.calculateRectangle(one,two);
    }

}
