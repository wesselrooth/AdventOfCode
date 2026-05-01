package com.example.AdventOfCode;
import java.util.List;

public class GridHelper {

    public Grid calculateColumnsForGrid(Grid grid){

        int longestRowSize = 0;
        final int columnDepth = grid.getRows().size();
        for (Row row: grid.getRows()){
            if (row.getRowContent().size() > longestRowSize){
                longestRowSize = row.getRowContent().size();
            }
        }
        Collumn collumn = null;

        for (int charIndex = 0; charIndex < longestRowSize; charIndex++) {
            if (collumn == null){
                collumn = new Collumn();
            }

            int emptyCharacterinRowCount = 0;
            StringBuilder numberString = new StringBuilder();

            for (Row row: grid.getRows()) {
                List<String> rowContent = row.getRowContent();

                String rowCharacter = "";
                if (charIndex < rowContent.size()){
                    rowCharacter = rowContent.get(charIndex);
                }else {
                    System.out.println("te groot");
                }

                if (rowCharacter.equals("*") | rowCharacter.equals("+")) {
                    collumn.setOparent(rowCharacter);
                    continue;
                }

                if (rowCharacter.isEmpty() || rowCharacter.isBlank()) {
                    emptyCharacterinRowCount++;

                }
                numberString.append(rowCharacter);

                if (emptyCharacterinRowCount == columnDepth) {
                    grid.addCollumn(collumn);
                    collumn = null;
                }
            }

            if (emptyCharacterinRowCount != columnDepth) {
                collumn.addNumber(Long.valueOf(numberString.toString().trim()));
            }

            if (charIndex == longestRowSize -1) {
                grid.addCollumn(collumn);
            }
        }
        return grid;
    }


}
