package com.aws.rt;

public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode h = head;
        while (head != null && head.next != null ){
            int v = head.val;
            int vn = head.next.val;
            if (v == vn) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return h;
    }
}
