package com.example.AdventOfCode;

public class Icon {

    private String symbol;

    private int x;
    private int y;

    public Icon(String symbol,int x, int y){
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol(){
        return symbol;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
