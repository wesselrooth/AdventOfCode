package com.example.AdventOfCode;

public class RedTile {

    private long x;
    private long y;
    private RedTile nextRedTile;

    public RedTile(long x,long y){
        this.x=x;
        this.y=y;
    }

    public long getX() {
        return x;
    }
    public long getY() {
        return y;
    }
    public RedTile getNextRedTile() {
        return nextRedTile;
    }
    public void setNextRedTile(RedTile nextRedTile) {
        this.nextRedTile = nextRedTile;
    }

}
