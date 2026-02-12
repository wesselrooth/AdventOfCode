package com.example.AdventOfCode;

public class Cycle {

    private final String cycleType;
    private final long cycleAmount;
    private final long oparant;

    public Cycle(String cycleType, long cycleAmount,long oparant){
        this.cycleType = cycleType;
        this.cycleAmount = cycleAmount;
        this.oparant = oparant;
    }

    public String getCycleType(){
        return cycleType;
    }

    public long getCycleAmount(){
        return cycleAmount;
    }

    public long getOparant(){
        return oparant;
    }
}
