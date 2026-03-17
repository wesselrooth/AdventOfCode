package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpriteManager {

    private List<String> spritePostion;

    public SpriteManager(int range, int registerX) throws SpriteException {

        if (range < 3){
            throw new SpriteException("List is to small to fit a Sprite");
        }

        this.spritePostion = new ArrayList<>(Collections.nCopies(range,"."));

        if (registerX == 0){
            spritePostion.set(registerX,"#");
            spritePostion.set(registerX + 1,"#");
            spritePostion.set(registerX + 2,"#");
            return;
        }

        if (registerX == range -1){
            spritePostion.set(registerX,"#");
            spritePostion.set(registerX -1,"#");
            spritePostion.set(registerX -2,"#");
            return;
        }

        spritePostion.set(registerX,"#");
        spritePostion.set(registerX - 1,"#");
        spritePostion.set(registerX + 1,"#");





    }

    public List<String> getSprite(){
        return spritePostion;
    }


}
