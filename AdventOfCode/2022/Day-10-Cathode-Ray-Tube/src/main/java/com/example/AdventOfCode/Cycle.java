package com.example.AdventOfCode;

public class Cycle {


    private final long cycleAmount;
    private final long oparant;

    public Cycle(long cycleAmount,long oparant){

        this.cycleAmount = cycleAmount;
        this.oparant = oparant;
    }
    public long getCycleAmount(){
        return cycleAmount;
    }

    public long getOperant(){
        return oparant;
    }
}
