package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class BeamManager {

    public List<Splitter> findAllSplitter(List<List<String>> input){

        List<Splitter> resultList = new ArrayList<>();

        for (int y = 0; y < input.size(); y++) {

            List<String> row = input.get(y);

            for (int x = 0; x< row.size(); x++){

                String icon = row.get(x);

                if (!icon.equals("^")){
                    continue;
                }

                resultList.add(new Splitter(x,y));
            }

        }

        return resultList;
    }

    public List<List<String>> createNewBeams(List<List<String>> input, List<Splitter> splitterList) {

        for (Splitter splitter: splitterList){

            int leftBeam = splitter.x() - 1;
            int rightBeam = splitter.x() + 1;

            List<String> row = input.get(splitter.y());

            row.set(leftBeam,"|");
            row.set(rightBeam,"|");

        }

        return input;
    }

    public List<List<String>> extendBeam(List<List<String>> input){

        for (int y = 0; y < input.size(); y++){

            List<String> row = input.get(y);

            for (int x = 0; x < row.size(); x++){

                String icon = row.get(x);

                if (!icon.equals("|")){
                    continue;
                }

                try {
                    List<String> nextRow = input.get(y + 1);
                    String nextRowIcon = nextRow.get(x);

                    if (nextRowIcon.equals("^")){
                        continue;
                    }

                    nextRow.set(x,"|");

                }catch (IndexOutOfBoundsException e ){
                    System.out.println("End of the collection");
                }

            }
        }

        return input;
    }

    public int countTouchingBeamsToSplitter(List<List<String>> input){

        int beamSplittingCount = 0;

        for (int y = 0; y < input.size(); y++){

            List<String> row = input.get(y);

            for (int x = 0; x < row.size(); x++){

                String icon = row.get(x);

                if (!icon.equals("|")){
                    continue;
                }

                try {
                    List<String> nextRow = input.get(y + 1);
                    String nextRowIcon = nextRow.get(x);

                    if (!nextRowIcon.equals("^")){
                        continue;
                    }

                    beamSplittingCount++;

                }catch (IndexOutOfBoundsException e ){
                    System.out.println("End of the collection");
                }

            }
        }
        return beamSplittingCount;
    }

}
