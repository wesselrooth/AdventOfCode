package com.example.AdventOfCode;

public class ColumnCalculator {

    public long calculateColumnOutput(Collumn collumn) {

        return switch (collumn.getOparent()) {
            case "*" -> {
                long result = collumn.getNumberList().get(0);

                for (int i = 1; i < collumn.getNumberList().size(); i++) {
                    result *= collumn.getNumberList().get(i);
                }
                yield  result;
            }
            case "+" -> {
                long result = collumn.getNumberList().get(0);

                for (int i = 1; i < collumn.getNumberList().size(); i++) {
                    result += collumn.getNumberList().get(i);
                }
                yield  result;
            }
            default -> throw new IllegalArgumentException("Unexpected value: " + collumn.getOparent());
        };


    }

}
