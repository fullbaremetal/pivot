package com.fullbaremetal.pivot.facebook;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null) return null;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        PriorityQueue<HeapElement> minHeap = new PriorityQueue<>();
        for(int i =0; i< lists.length; i++) {
            if(lists[i] == null) continue;
            minHeap.add(new HeapElement(lists[i]));
        }
        while(!minHeap.isEmpty()) {
            HeapElement heapElement = minHeap.poll();
            tail.next = heapElement.node;
            tail = tail.next;
            if(heapElement.node.next!=null) minHeap.add(new HeapElement(heapElement.node.next));
        }
        return head.next;
    }
}

class HeapElement implements Comparable<HeapElement> {
    ListNode node;
    int val;

    public HeapElement(ListNode node) {
        this.node = node;
        this.val = node.val;
    }

    @Override
    public int compareTo(HeapElement o) {
        if(o == null) return 1;
        return Integer.compare(this.val, o.val);
    }
}