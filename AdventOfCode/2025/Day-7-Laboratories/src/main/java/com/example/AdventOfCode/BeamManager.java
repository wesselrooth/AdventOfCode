package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class BeamManager {

    public Grid createNewBeams(Grid grid, List<Splitter> splitterList) {

        for (Splitter splitter: splitterList){

            int leftBeam = splitter.x() - 1;
            int rightBeam = splitter.x() + 1;

            Row row = grid.getRow(splitter.y());

            if (row.getIcon(rightBeam).getIcon().equals("^")){
                System.out.print("SPLITTER");
            }

            row.setIcon(leftBeam,"|");
            row.setIcon(rightBeam,"|");
        }

        return grid;
    }

    public Grid extendAllBeams(Grid grid){

        for (int y = 0; y < grid.getRowSize() - 1; y++){

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

    public long countTouchingBeamsToSplitter(Grid grid) {

        long beamSplittingCount = 0;

        for (int y = 0; y < grid.getRowSize() -1; y++) {

            Row row = grid.getRow(y);

            for (int x = 0; x < row.getRowSize(); x++){

                Icon icon = row.getIcon(x);
                if (!icon.getIcon().equals("|")){
                    continue;
                }

                Row nextRow = grid.getRow(y + 1);
                Icon nextRowIcon = nextRow.getIcon(x);

                if (nextRowIcon.getIcon().equals("^")) {
                    beamSplittingCount++;
                }

            }
        }
        return beamSplittingCount;
    }

    public int findPathsDownInGrid(Grid grid) {

        int result = 0;

        Row row = grid.getRow(0);

        for (int x = 0; x< row.getRowSize(); x++){

            Icon icon = row.getIcon(x);

            if (icon.getIcon().equals("S")){

                Row nextRow = grid.getRow(icon.getY() + 1);
                Icon nextIcon = nextRow.getIcon(icon.getX());
                result += calculatePathsDown(nextIcon,grid);
                nextIcon.setChecked(true);
            }

        }
        return result;
    }

    public int calculatePathsDown(Icon current,Grid grid) {

        int result = 0;

        if (current.isChecked()){
            return current.getPathsDown();
        }

        int y = current.getY();

        if (y == grid.getRowSize() -1){
            current.setChecked(true);
            current.setPathsDown(1);
            return 1;
        }

        Row nextRow = grid.getRow( y + 1);
        Icon iconBelow = nextRow.getIcon(current.getX());

        if (iconBelow.getIcon().equals("|") ||iconBelow.getIcon().equals(".")){

            result += calculatePathsDown(iconBelow,grid);

        }else if (iconBelow.getIcon().equals("^")){

            Icon left = nextRow.getIcon(Math.max(0, iconBelow.getX() - 1));
            Icon right = nextRow.getIcon(Math.min(nextRow.getRowSize() - 1, iconBelow.getX() + 1));

            result += calculatePathsDown(left, grid);
            result += calculatePathsDown(right, grid);
        }

        current.setChecked(true);
        current.setPathsDown(result);

        return result;

    }

    public Grid locateInitialBeam(Grid grid) {

        for (int y = 0; y < grid.getRowSize(); y++) {

            Row row = grid.getRow(y);

            for (int x = 0; x < row.getRowSize(); x++) {
                Icon icon = row.getIcon(x);

                if (icon.getIcon().equals("S")){
                    grid.getRow(y+1).getIcon(x).setIcon("|");
                    return grid;
                }

            }

        }
        return grid;
    }

}
