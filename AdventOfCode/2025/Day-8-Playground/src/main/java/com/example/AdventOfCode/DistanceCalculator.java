package com.example.AdventOfCode;

public class DistanceCalculator {

    public double calculateEuclideanDistance(JunctionBox box1, JunctionBox box2) {

        double xDistance = Math.pow(box1.getX() - box2.getX(), 2);
        double yDistance = Math.pow(box1.getY() - box2.getY(), 2);
        double zDistance = Math.pow(box1.getZ() - box2.getZ(), 2);
        double sum = xDistance + yDistance + zDistance;

        double squireRoot = Math.sqrt(sum);

        return squireRoot;
    }

}
