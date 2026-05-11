package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private List<Row> rows = new ArrayList<>();
    private List<Collumn> collumns = new ArrayList<>();

    public void addRow(Row row){
        rows.add(row);
    }

    public Row getRow(int i){
        return rows.get(i);
    }

    public List<Row> getRows(){
        return rows;
    }

    public List<Collumn> getCollumns() {
        return collumns;
    }

    public void setCollumns(List<Collumn> collumns) {
        this.collumns = collumns;
    }
    public Collumn getColumn(int index) {
        return collumns.get(index);
    }
    public void addCollumn(Collumn collumn) {
        collumns.add(collumn);
    }
}
