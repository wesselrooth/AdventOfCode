package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class Row {

    private List<Icon> members = new ArrayList<>();

    public Icon getIcon(int index){
        return members.get(index);
    }

    public void addIcon(Icon icon){
        members.add(icon);
    }

    public int getRowSize(){
        return members.size();
    }

    public void setIcon(int index, String icon){

        Icon indexIcon = members.get(index);
        indexIcon.changeIcon(icon);

    }

    public List<Icon> getMembers(){
        return members;
    }

}
