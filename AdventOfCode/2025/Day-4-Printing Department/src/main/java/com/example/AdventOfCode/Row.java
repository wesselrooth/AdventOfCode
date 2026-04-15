package com.example.AdventOfCode;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

public class Row {

    List<Icon> rowContent = new ArrayList<>();

    public Row(List<Icon> rowContent){
        this.rowContent = rowContent;
    }

    public Icon getItem(int i){
        return rowContent.get(i);
    }

    public List<Icon> getRowContent(){
        return rowContent;
    }
}
