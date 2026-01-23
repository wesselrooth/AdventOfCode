package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class Plot {

    private final String letter;
    private boolean isChecked;
    private boolean isTopChecked;
    private boolean isBottomChecked;
    private boolean isLeftChecked;
    private boolean isRightChecked;

    private final int x;
    private final int y;

    public Plot(String letter, int x, int y){
        this.letter = letter;
        this.x = x;
        this.y = y;
    }

    public String getLetter(){
        return letter;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String getCoordinateString(){
        return getX() + ":" + getY();
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked){
        this.isChecked = checked;
    }

    public void setTopChecked(boolean checked){
        this.isTopChecked = checked;
    }
    public boolean isTopChecked(){
        return isTopChecked;
    }

    public void setBottomChecked(boolean checked){
        this.isBottomChecked = checked;
    }
    public boolean isBottomChecked(){
        return isBottomChecked;
    }

    public void setLeftChecked(boolean checked){
        this.isLeftChecked = checked;
    }

    public boolean isLeftChecked(){
        return isLeftChecked;
    }

    public void setRightChecked(boolean checked){
        this.isRightChecked = checked;
    }

    public boolean isRightChecked(){
        return isRightChecked;
    }
}
