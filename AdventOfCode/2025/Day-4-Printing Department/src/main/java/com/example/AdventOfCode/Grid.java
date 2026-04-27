package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private List<Row> rows = new ArrayList<>();

    public Grid(){

    }

    public void addRow(Row row){
        rows.add(row);
    }

    public Row getRow(int i){
        return rows.get(i);
    }

    public List<Row> getRows(){
        return rows;
    }
}
