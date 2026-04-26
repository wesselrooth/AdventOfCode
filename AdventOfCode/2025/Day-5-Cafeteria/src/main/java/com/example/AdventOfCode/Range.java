package com.example.AdventOfCode;

public class Range {

    private long min;
    private long max;
    private boolean redundent = false;

    public Range(long min, long max){
        this.min = min;
        this.max = max;
    }

    public long getMin(){
        return min;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public void setRedundent(boolean redundent){
        this.redundent = redundent;
    }
    public boolean getRedundent(){
        return redundent;
    }
}
