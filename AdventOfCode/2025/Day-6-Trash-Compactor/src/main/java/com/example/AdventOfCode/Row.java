package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class Row {

    List<String> rowContent = new ArrayList<>();

    public void addIcon(String icon){
        rowContent.add(icon);
    }

    public String getItem(int i) {
        return rowContent.get(i);
    }

    public List<String> getRowContent(){
        return rowContent;
    }

    public void setRowContent(List<String> rowContent) {
        this.rowContent = rowContent;
    }
}
