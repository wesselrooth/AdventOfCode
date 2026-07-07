package com.example.AdventOfCode;

import org.apache.logging.log4j.core.tools.picocli.CommandLine;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private List<Row> rows =  new ArrayList<>();

    public List<Row> getRows() {
        return rows;
    }
    public void setRows(List<Row> rows) {
        this.rows = rows;
    }
    public void addRow(Row row){
        rows.add(row);
    }

}
