package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class Region {

    private final String letter;
    private int id;
    private final List<Plot> plotList = new ArrayList<>();

    int topSides;
    int bottomSides;
    int rightSides;
    int leftSides;

    public Region(String letter){
        this.letter = letter;
    }

    public int getPlotListSize(){
        return plotList.size();
    }

    public void setId(int id){
        this.id = id;
    }

    public String getIdString(){
        return letter + ":" + id;
    }

    public List<Plot> getPlotList(){
        return plotList;
    }

    public void addAllPlots(List<Plot> plotList){
        for (Plot plot : plotList) {
            this.plotList.add(plot);
        }
    }

    public void addTopSides(){
        this.topSides++;
    }

    public int getTopSides(){
        return topSides;
    }

    public void addBottomSide(){
        this.bottomSides++;
    }
    public int getBottomSides(){
        return bottomSides;
    }

    public void addRightSide(){
        this.rightSides++;
    }
    public int getRightSides(){
        return rightSides;
    }

    public void addLeftSide(){
        this.leftSides++;
    }

    public int getLeftSides(){
        return leftSides;
    }

    public int getTotalSides(){
        return topSides+bottomSides+leftSides+rightSides;
    }
}
