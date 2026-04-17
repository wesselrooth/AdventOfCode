package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class Row {

    List<Icon> rowContent = new ArrayList<>();

    public Row(){

    }

    public void addIcon(Icon icon){
        rowContent.add(icon);
    }

    public Icon getItem(int i) {
        return rowContent.get(i);
    }

    public List<Icon> getRowContent(){
        return rowContent;
    }
}
