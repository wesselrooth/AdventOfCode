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

    private boolean rangeMinOverlaps(Range current, Range range){
        return current.getMin() >= range.getMin() && current.getMin() <= range.getMax();
    }

    private boolean rangeMaxOverlaps(Range current, Range range){
        return current.getMax() >= range.getMin() && current.getMax() <= range.getMax();
    }

    private boolean rangeOverlaps(Range current, Range range){
        return current.getMin() <= range.getMin() && current.getMax() >= range.getMax();
    }

    private boolean rangeIsTheSame(Range current, Range range){
        return current.getMin() >= range.getMin() && current.getMax() <= range.getMax();
    }

    public long calculateFreshIds() {

        List<Range> checkedRanges = new ArrayList<>();
        RANGELOOP: for (Range current : rangeList) {

            for (int i = 0; i < checkedRanges.size(); i++) {
                Range checkRange = checkedRanges.get(i);

                if (checkRange.getRedundent()){
                    continue;
                }
                if (rangeIsTheSame(current,checkRange)) {
                    continue RANGELOOP;
                }
                if (rangeMinOverlaps(current,checkRange)) {
                    current.setMin(checkRange.getMax() + 1);
                }
                if (rangeMaxOverlaps(current,checkRange)) {
                    current.setMax(checkRange.getMin() - 1);
                }
                if (rangeOverlaps(current,checkRange)){
                    checkRange.setRedundent(true);
                }
            }
            checkedRanges.add(current);
        }

        long result = 0;
        for (Range range: checkedRanges){
            if (range.getRedundent()){
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
