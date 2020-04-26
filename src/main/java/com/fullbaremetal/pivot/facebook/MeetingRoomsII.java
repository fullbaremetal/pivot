package com.fullbaremetal.pivot.facebook;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int ans=0;
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        for(int i=0;i<intervals.length;i++){
            while(!ends.isEmpty() && ends.peek()<=intervals[i][0]) {
                ends.poll();
            }
            ends.add(intervals[i][1]);
            ans = Integer.max(ans, ends.size());
        }
        return ans;
    }
}
