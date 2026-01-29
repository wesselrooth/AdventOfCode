package com.example.AdventOfCode;

import java.util.ArrayList;

import java.util.List;

public class BeamManager {

    public List<Splitter> findAllSplitter(Grid input){

        List<Splitter> resultList = new ArrayList<>();

        for (int y = 0; y < input.getRowSize(); y++) {

            Row row = input.getRow(y);

            for (int x = 0; x< row.getRowSize(); x++){

                Icon icon = row.getIcon(x);

                if (!icon.getIcon().equals("^")){
                    continue;
                }

                resultList.add(new Splitter(x,y));
            }

        }

        return resultList;
    }
    public Grid createNewBeams(Grid grid, List<Splitter> splitterList) {

        for (Splitter splitter: splitterList){

            int leftBeam = splitter.x() - 1;
            int rightBeam = splitter.x() + 1;

            Row row = grid.getRow(splitter.y());

            row.setIcon(leftBeam,"|");
            row.setIcon(rightBeam,"|");
        }

        return grid;
    }

    public Grid extendAllBeams(Grid grid){

        for (int y = 0; y < grid.getRowSize(); y++){

            Row row = grid.getRow(y);

            for (int x = 0; x < row.getRowSize(); x++){

                if (y == grid.getRowSize() -1){
                    continue;
                }

                Icon icon = row.getIcon(x);
                if (!icon.getIcon().equals("|")){
                    continue;
                }

                Row nextRow = grid.getRow(y + 1);
                Icon nextRowIcon = nextRow.getIcon(x);

                if (nextRowIcon.getIcon().equals("^")){
                    continue;
                }
                nextRow.setIcon(x,"|");
            }
        }

        return grid;
    }

    public int countTouchingBeamsToSplitter(Grid grid){

        int beamSplittingCount = 0;

        for (int y = 0; y < grid.getRowSize(); y++){

            Row row = grid.getRow(y);

            for (int x = 0; x < row.getRowSize(); x++){

                if (y == grid.getRowSize() -1){
                    continue;
                }

                Icon icon = row.getIcon(x);
                if (!icon.getIcon().equals("|")){
                    continue;
                }

                Row nextRow = grid.getRow(y + 1);
                Icon nextRowIcon = nextRow.getIcon(x);

                if (!nextRowIcon.getIcon().equals("^")){
                    continue;
                }

                beamSplittingCount++;


            }
        }
        return beamSplittingCount;
    }

}
