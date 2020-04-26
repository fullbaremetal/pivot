package com.fullbaremetal.pivot.facebook;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int removed = 0;
        int i = 0;
        while(i<intervals.length) {
            int end = intervals[i][1];
            while(i<intervals.length-1 && end > intervals[i+1][0]) {
                removed++;
                end=Integer.min(end, intervals[i+1][1]);
                i++;
            }
            i++;
        }
        return removed;
    }
}
