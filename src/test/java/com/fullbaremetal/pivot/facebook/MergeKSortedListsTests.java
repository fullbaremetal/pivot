package com.fullbaremetal.pivot.facebook;

import org.junit.Assert;
import org.junit.Test;

public class MergeKSortedListsTests {

    @Test
    public  void testSimple() {
        ListNode[] lists = new ListNode[3];
        lists[0] = constructList(new int[]{1,4,5});
        lists[1] = constructList(new int[]{1,3,4});
        lists[2] = constructList(new int[]{2,6});
        ListNode expected = constructList(new int[]{1,1,2,3,4,4,5,6});
        MergeKSortedLists m = new MergeKSortedLists();
        ListNode actual = m.mergeKLists(lists);
        while(actual!=null){
            if(expected==null) {
                Assert.fail("actual contains more elements: " + actual.val);
            }
            if(actual.val!=expected.val) {
                Assert.fail("unexpected val"+ actual.val + " "+ expected.val);
            }
            actual= actual.next;
            expected = expected.next;
        }
        Assert.assertTrue(expected==null);
    }

    @Test
    public  void testEmpty() {
        ListNode[] lists = new ListNode[0];
        MergeKSortedLists m = new MergeKSortedLists();
        ListNode actual = m.mergeKLists(lists);
        Assert.assertTrue(actual==null);
    }

    @Test
    public void testEmptyEmpty() {
        ListNode[] lists = new ListNode[2];
        MergeKSortedLists m = new MergeKSortedLists();
        ListNode actual = m.mergeKLists(lists);
        Assert.assertTrue(actual==null);
    }


    private ListNode constructList(int[] ints)  {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for(int i=0;i<ints.length;i++) {
            ListNode cur = new ListNode(ints[i]);
            tail.next = cur;
            tail = tail.next;
        }
        return head.next;
    }
}
