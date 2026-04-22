package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class RangeDetector {

    private List<Range> rangeList;

    public RangeDetector(List<Range> rangeList) {
        this.rangeList = rangeList;
    }

    public boolean isIdInAnyRange(long number) {

        for(Range range : rangeList){
            if (number >= range.min() && number <= range.max()){
                return true;
            }
        }
        return false;
    }

    public List<Long> returnFreshIds(List<Long> idList) {

        List<Long> resultList = new ArrayList<>();

        for (Long id: idList){
            if (isIdInAnyRange(id)){
                resultList.add(id);
            }
        }

        return resultList;
    }
}
