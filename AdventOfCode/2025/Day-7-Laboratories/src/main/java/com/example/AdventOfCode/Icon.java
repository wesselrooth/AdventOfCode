package com.example.AdventOfCode;

public class Icon {

    private String icon;
    private final int y;
    private final int x;
    private boolean isChecked = false;
    private boolean needsToBeChecked = false;
    private int pathsDown;


    public Icon(String icon, int x, int y){
        this.icon = icon;
        this.y = y;
        this.x = x;
    }

    public String getIcon(){
        return icon;
    }

    public int getY(){
        return y;
    }

    public int getX(){
        return x;
    }

    public boolean isChecked(){
        return isChecked;
    }

    public void setChecked(boolean checked){
        this.isChecked = checked;
    }

    public void changeIcon(String newIcon){
        this.icon = newIcon;
    }

    public void setPathsDown(int amount){
        this.pathsDown = amount;
    }

    public int getPathsDown(){
        return pathsDown;
    }
}
