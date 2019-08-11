package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RemoveDuplicatesfromSortedListTest {
    private static RemoveDuplicatesfromSortedList s = new RemoveDuplicatesfromSortedList();
    private ListNode n;
    private ListNode m;



    @Parameterized.Parameters
    public static Collection data() {

        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;


        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(1);
        ListNode r3 = new ListNode(2);
        ListNode r4 = new ListNode(3);
        ListNode r5 = new ListNode(3);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;

        return Arrays.asList(new Object[][]{
                {r1, l11}
        });
    }

    public RemoveDuplicatesfromSortedListTest(ListNode n, ListNode m){
        this.n = n;
        this.m = m;
    }

    @Test
    public void deleteDuplicatesTest(){
        ListNode nn = s.deleteDuplicates(n);
        while (m != null && nn != null) {
            assertEquals(m.val, nn.val);
            m = m.next;
            nn = nn.next;
        }
    }
}