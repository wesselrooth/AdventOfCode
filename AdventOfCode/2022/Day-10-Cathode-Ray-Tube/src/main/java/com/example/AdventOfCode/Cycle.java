package com.example.AdventOfCode;

public class Cycle {


    private final int cycleAmount;
    private final int oparant;

    public Cycle(int cycleAmount,int operant){

        this.cycleAmount = cycleAmount;
        this.oparant = operant;
    }
    public long getCycleAmount(){
        return cycleAmount;
    }

    public int getOperant(){
        return oparant;
    }
}
