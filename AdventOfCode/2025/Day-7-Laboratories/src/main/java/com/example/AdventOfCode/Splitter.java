package com.example.AdventOfCode;

public record Splitter(int x, int y) {

    @Override
    public String toString(){
        return "%s,%s".formatted(x,y);
    }
}
