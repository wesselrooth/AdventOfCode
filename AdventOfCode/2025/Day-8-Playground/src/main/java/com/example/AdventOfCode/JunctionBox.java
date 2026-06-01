package com.example.AdventOfCode;

import java.util.HashMap;

public class JunctionBox {

    private final long x;
    private final long y;
    private final long z;
    private HashMap<JunctionBox,Double> distanceMap = new HashMap<>();

    public JunctionBox(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long getZ() {
        return z;
    }

    public void addDistance(JunctionBox junctionBox,double distance) {
        distanceMap.put(junctionBox,distance);
    }

    public HashMap<JunctionBox,Double> getDistanceMap() {
        return distanceMap;
    }

    @Override
    public String toString() {
        return getX() + "," + getY() + "," + getZ();
    }

}
