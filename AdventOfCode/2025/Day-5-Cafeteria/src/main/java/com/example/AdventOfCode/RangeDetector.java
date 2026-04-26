package com.example.AdventOfCode;
import java.util.ArrayList;
import java.util.List;

public class RangeDetector {

    private final List<Range> rangeList;

    public RangeDetector(List<Range> rangeList) {
        this.rangeList = rangeList;
    }

    public boolean isIdInAnyRange(long number) {
        for(Range range : rangeList) {
            if (number >= range.getMin() && number <= range.getMax()) {
                return true;
            }
        }
        return false;
    }

    public long calculateFreshIds() {

        List<Range> checkedRanges = new ArrayList<>();
        long result = 0;
        RANGELOOP: for (Range range : rangeList) {

            for (int i = 0; i < checkedRanges.size(); i++) {
                Range checkRange = checkedRanges.get(i);

                if (checkRange.getRedundent() == true){
                    continue;
                }

                if (range.getMin() >= checkRange.getMin() && range.getMax() <= checkRange.getMax()) {
                    continue RANGELOOP;
                }
                if (range.getMin() >= checkRange.getMin() && range.getMin() <= checkRange.getMax()) {
                    range.setMin(checkRange.getMax() + 1);
                }
                if (range.getMax() >= checkRange.getMin() && range.getMax() <= checkRange.getMax()) {
                    range.setMax(checkRange.getMin() - 1);
                }

                if (range.getMin() <= checkRange.getMin() && range.getMax() >= checkRange.getMax()){
                    checkRange.setRedundent(true);
                }

            }
            checkedRanges.add(range);
        }

        for (Range range: checkedRanges){
            if (range.getRedundent() == true){
                continue;
            }
            result += Math.abs(range.getMin() - range.getMax()) + 1;
        }

        return result;
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
