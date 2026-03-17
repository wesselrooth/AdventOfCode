package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sprite {

    private List<String> spriteRange;

    private final int range;

    public Sprite(int range) throws SpriteException {

        if (range < 3){
            throw new SpriteException("List is to small to fit a Sprite");
        }
        this.range = range;
        this.spriteRange = new ArrayList<>(Collections.nCopies(range,"."));
    }

    public String moveSprite(int registerX){

        if (registerX <= 0){
            spriteRange.set(0,"#");
            spriteRange.set(1,"#");
            spriteRange.set(2,"#");
        }else if (registerX >= range -1){
            spriteRange.set(range - 1,"#");
            spriteRange.set(range - 2,"#");
            spriteRange.set(range - 3,"#");
        }else {
            spriteRange.set(registerX,"#");
            spriteRange.set(registerX - 1,"#");
            spriteRange.set(registerX + 1,"#");
        }
        return String.join("", spriteRange);
    }
}
