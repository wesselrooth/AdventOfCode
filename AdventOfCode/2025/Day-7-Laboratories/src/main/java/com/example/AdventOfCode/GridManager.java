package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class GridManager {

    public List<Splitter> findAllSplitter(Grid grid) {

        List<Splitter> resultList = new ArrayList<>();

        for (int y = 0; y < grid.getRowSize(); y++) {

            Row row = grid.getRow(y);

            for (int x = 0; x< row.getRowSize(); x++){

                Icon icon = row.getIcon(x);

                if (icon.getIcon().equals("^")){
                    resultList.add(new Splitter(x,y));
                }
            }

        }

        return resultList;
    }

}
