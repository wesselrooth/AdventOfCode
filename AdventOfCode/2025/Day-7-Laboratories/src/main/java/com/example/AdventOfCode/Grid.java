package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private List<Row> rows = new ArrayList<>();

    public void addRow(Row row){
        this.rows.add(row);
    }

    public Row getRow(int rowNumber){
        return rows.get(rowNumber);
    }

    public int getRowSize(){
        return rows.size();
    }



}
