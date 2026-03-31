package com.example.AdventOfCode.managers;

import java.util.ArrayList;
import java.util.List;

public class CircuitManager {

    public boolean spriteTouchesCircuitString(String circuit, String sprite){
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
