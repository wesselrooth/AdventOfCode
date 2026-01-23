package com.example.AdventOfCode;

public class Rotator {

    public int pointer;

    public int listlength;

    private int crosZeroCount = 0;

    public Rotator(int amount ){
        listlength = amount;

    }

    public Direction detectDirection(String input) throws InputException {

        if (input.isEmpty()){
            throw new InputException("No input given");
        }

        if (input.contains("R")){

            return Direction.RIGHT;

        } else if (input.contains("L")) {

            return Direction.LEFT;

        } else {
            throw new InputException("No direction found");
        }

    }

    public int rotateRight(int amount ){

        for (int i = 0; i < amount; i++) {

            pointer++;

            if (pointer == listlength){
                pointer = 0;
            }

            if (pointer == 0){
                incrementZeroCounter();
            }

        }

        return pointer;
    }

    public int rotateLeft(int amount ){

        for (int i = 0; i < amount; i++) {

            pointer--;

            if (pointer == -1){
                pointer = listlength -1;
            }

            if (pointer == 0){
                incrementZeroCounter();
            }

        }

        return pointer;
    }

    public void incrementZeroCounter(){
        crosZeroCount++;
    }

    public int getCrosZeroCount(){
        return crosZeroCount;
    }


}
