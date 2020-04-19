/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * @author WhatAKitty
 * @date 2020/04/19
 * @since 1.0.0
 **/
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode h = null;
        ListNode left = head;
        ListNode right = left.next;
        while (right != null) {
            if (h == null) h = right;
            ListNode tmp = right.next;
            right.next = left;
            left.next = tmp;

            left = left.next;
            right = left.next;
        }

        return h;
    }

}
