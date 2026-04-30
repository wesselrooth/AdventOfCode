package com.example.AdventOfCode;

public class ColumnManager {

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

    public Collumn padNumbers(Collumn collumn) {

        int longestNumberSize = getLongestNumberStringSize(collumn);

        return switch (collumn.getOparent()) {
            case "*" -> {

                for (int i = 0; i < collumn.getNumberStringList().size(); i++) {
                    String numberString = collumn.getNumberStringList().get(i);

                    if (numberString.length() < longestNumberSize) {
                        for (int j = numberString.length(); j < longestNumberSize; j++) {
                            numberString = "#" + numberString;
                        }

                    }
                    collumn.getNumberStringList().set(i, numberString);

                }

                yield collumn;
            }
            case "+" -> {

                for (int i = 0; i < collumn.getNumberStringList().size(); i++) {
                    String numberString = collumn.getNumberStringList().get(i);

                    if (numberString.length() < longestNumberSize) {
                        for (int j = numberString.length(); j < longestNumberSize; j++) {
                            numberString = numberString + "#";
                        }

                    }
                    collumn.getNumberStringList().set(i, numberString);
                }

                yield collumn;
            }
            default -> throw new IllegalArgumentException("Unexpected value: " + collumn.getOparent());
        };
    }

    private int getLongestNumberStringSize(Collumn collumn) {
        int longestNumberSize = 0;
        for (String numberString : collumn.getNumberStringList()) {
            if (numberString.length() > longestNumberSize) {
                longestNumberSize = numberString.length();
            }
        }
        return longestNumberSize;
    }

}
