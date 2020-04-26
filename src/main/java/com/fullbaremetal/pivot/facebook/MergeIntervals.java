package com.fullbaremetal.pivot.facebook;

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for(int i =0;i<intervals.length;i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(intervalList);
        List<Interval> mergedList = new ArrayList<>();
        for(int i = 0;i<intervalList.size();) {
            int start = intervalList.get(i).start;
            int end = intervalList.get(i).end;
            i++;
            while(i<intervalList.size()) {
                if(intervalList.get(i).start>end) {
                    break;
                }
                end = Integer.max(end, intervalList.get(i).end);
                i++;
            }
            mergedList.add(new Interval(start, end));
        }
        int[][] ans = new int[mergedList.size()][2];
        for(int i =0;i<mergedList.size();i++) {
            ans[i][0] = mergedList.get(i).start;
            ans[i][1] = mergedList.get(i).end;
        }
        return ans;
    }
}

class Interval implements Comparable<Interval> {
    Integer start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Interval o) {
        return start.compareTo(o.start);
    }
}
