package com.example.AdventOfCode.managers;

import com.example.AdventOfCode.Cycle;
import com.example.AdventOfCode.Sprite;
import com.example.AdventOfCode.exceptions.CycleException;
import com.example.AdventOfCode.exceptions.SpriteException;
import com.example.AdventOfCode.logs.JsonLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CircuitManager {

    public boolean spriteTouchesPixelToDraw(String circuit, String sprite){
        int toDrawIndex;
        int spriteIndex = sprite.indexOf("#");

        List<Integer> spriteIndexList = new ArrayList<>();
        for (int i = spriteIndex; i < spriteIndex + 3; i++) {
            spriteIndexList.add(i);
        }

        if (circuit.isEmpty()){
            toDrawIndex = 0;
        } else {
            toDrawIndex = circuit.length();
        }

        return spriteIndexList.stream().anyMatch( i -> i.equals(toDrawIndex));
    }

    public String updateCircuit(boolean touchesSprite, String crtString){
        String toAddCharacter;

        if (touchesSprite){
            toAddCharacter = "#";
        }else {
            toAddCharacter = ".";
        }

        return crtString + toAddCharacter;
    }

}
