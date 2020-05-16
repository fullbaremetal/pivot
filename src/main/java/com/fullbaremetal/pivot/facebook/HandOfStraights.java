package com.fullbaremetal.pivot.facebook;

import java.util.*;

public class HandOfStraights {
    public static boolean isNStraightHand(int[] hand, int W) {
            if(W==1) return true;
            if(hand.length%W!=0) return false;
            Arrays.sort(hand);
            int i=0;
            TreeMap<Entry, Integer> s = new TreeMap<>();
            while(i<hand.length){
                Entry n = new Entry(hand[i], 1);
                Entry e = s.lowerKey(n);
                if(e==null) s.put(n, s.getOrDefault(n,0)+1);
                else {
                    if(e.last+1!=hand[i]) return false;
                    if(s.get(e)==1) s.remove(e);
                    else s.put(e, s.get(e)-1);
                    Entry cur = new Entry(hand[i], e.len+1);
                    if(cur.len<W) s.put(cur, s.getOrDefault(cur,0)+1);
                }
                i++;
            }
            return s.isEmpty();
    }
}

class Entry implements Comparable<Entry> {
    int last;
    int len;
    public Entry(int last, int len){
        this.last=last;
        this.len=len;
    }
    public int compareTo(Entry e){
        return e.last==last?Integer.compare(len, e.len):Integer.compare(last, e.last);
    }
}