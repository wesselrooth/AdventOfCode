package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class BeamManager {

    public List<Splitter> findAllSplitter(Grid grid){

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

        for (int y = 0; y < grid.getRowSize() -1; y++){

            Row row = grid.getRow(y);

            for (int x = 0; x < row.getRowSize(); x++){

                Icon icon = row.getIcon(x);

                if (!icon.getIcon().equals("|")){
                    continue;
                }

                Row nextRow = grid.getRow(y + 1);
                Icon nextRowIcon = nextRow.getIcon(x);

                if (nextRowIcon.getIcon().equals(".")){
                    nextRow.setIcon(x,"|");
                }

            }
        }

        return grid;
    }

    public int countTouchingBeamsToSplitter(Grid grid){

        int beamSplittingCount = 0;

        for (int y = 0; y < grid.getRowSize() -1; y++){

            Row row = grid.getRow(y);

            for (int x = 0; x < row.getRowSize(); x++){

                Icon icon = row.getIcon(x);
                if (!icon.getIcon().equals("|")){
                    continue;
                }

                Row nextRow = grid.getRow(y + 1);
                Icon nextRowIcon = nextRow.getIcon(x);

                if (nextRowIcon.getIcon().equals("^")){
                    beamSplittingCount++;
                }

            }
        }
        return beamSplittingCount;
    }

    public int findPathsDownInGrid(Grid grid) {

        int result = 0;

        for (int y = 0; y < grid.getRowSize(); y++){

            Row row = grid.getRow(y);

            for (int x = 0; x< row.getRowSize(); x++){
                Icon icon = row.getIcon(x);

                if (icon.isChecked()){
                    continue;
                }

                if (icon.getIcon().equals("|")){
                    result += calculatePathsDown(icon,grid);
                    icon.setChecked(true);
                }


            }

        }

        return result;
    }

    public int calculatePathsDown(Icon current,Grid grid){
        int result = 0;



        for (int y = current.getY(); y < grid.getRowSize(); y++){

            Row row = grid.getRow(y);

            if (current.isChecked()){

                return current.getPathsDown();
            }

            if ( y == grid.getRowSize() - 1){
                return 1;
            }

            Icon nextIcon = grid.getRow(y + 1).getIcon(current.getX());

            if (nextIcon.getIcon().equals("|")){
                int tmpResult = calculatePathsDown(nextIcon,grid);
                nextIcon.setPathsDown(tmpResult);
                return tmpResult;
            }

            if (!grid.getRow(y + 1).getIcon(current.getX()).getIcon().equals("^")){
                // not a ^ => continue
                continue;
            }

            if (nextIcon.getY() == grid.getRowSize() -1){
                current.setChecked(true);
                current.setPathsDown(2);

                Icon left = grid.getRow(y+1).getIcon(current.getX() -1);
                Icon right= grid.getRow(y+1).getIcon(current.getX() +1);

                left.setChecked(true);
                right.setChecked(true);

                return 2;
            }

            if (nextIcon.isChecked()){
                return nextIcon.getPathsDown();
            }

            Icon left = grid.getRow(y+1).getIcon(current.getX() -1);
            Icon right= grid.getRow(y+1).getIcon(current.getX() +1);
            List<Icon> toCheck = List.of(left,right);

            for (Icon tocheckIcon: toCheck){
                int tmpResult = calculatePathsDown(tocheckIcon,grid);
                tocheckIcon.setPathsDown(tmpResult);
                tocheckIcon.setChecked(true);
                result += tmpResult;
            }

            nextIcon.setPathsDown(result);
            nextIcon.setChecked(true);
            current.setChecked(true);
            current.setPathsDown(result);
        }

        return result;
    }

}
