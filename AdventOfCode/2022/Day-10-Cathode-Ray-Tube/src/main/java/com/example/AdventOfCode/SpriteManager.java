package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpriteManager {

    private List<String> spritePostion;

    private final int range;

    public SpriteManager(int range) throws SpriteException {

        if (range < 3){
            throw new SpriteException("List is to small to fit a Sprite");
        }
        this.range = range;
        this.spritePostion = new ArrayList<>(Collections.nCopies(range,"."));
    }

    public String moveSprite(int registerX){

        if (registerX <= 0){
            spritePostion.set(0,"#");
            spritePostion.set(1,"#");
            spritePostion.set(2,"#");
        }else if (registerX >= range -1){
            spritePostion.set(range - 1,"#");
            spritePostion.set(range - 2,"#");
            spritePostion.set(range - 3,"#");
        }else {
            spritePostion.set(registerX,"#");
            spritePostion.set(registerX - 1,"#");
            spritePostion.set(registerX + 1,"#");
        }
        return String.join("", spritePostion);
    }
}
