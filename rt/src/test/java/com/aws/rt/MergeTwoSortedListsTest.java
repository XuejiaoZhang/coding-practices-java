package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

// TODO: need to debug, submitted on Leetcode, but running tests on IDE was stuck.


@RunWith(Parameterized.class)
public class MergeTwoSortedListsTest {
    private static MergeTwoSortedLists s = new MergeTwoSortedLists();
    private ListNode l1;
    private ListNode l2;
    private ListNode r;


    @Parameterized.Parameters
    public static Collection data() {

        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;


        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;


        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(1);
        ListNode r3 = new ListNode(2);
        ListNode r4 = new ListNode(3);
        ListNode r5 = new ListNode(4);
        ListNode r6 = new ListNode(4);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;
        r5.next = r6;

        System.out.print(l11);
        System.out.print(r1);
        return Arrays.asList(new Object[][]{
                {l11, l12, r1},
        });
    }

    public MergeTwoSortedListsTest(ListNode l1, ListNode l2, ListNode r){
        this.l1 = l1;
        this.l2 = l2;
        this.r = r;
    }

    @Test
    public void LCPTest(){
        assertEquals(r, s.mergeTwoLists(l1, l2));
    }
}
