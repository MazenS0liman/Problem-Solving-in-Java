package LeetCode.LinkedList;

/*
    ----------------------------------------------------------------
    | Problem: Maximum Twin Sum of a Linked List
    | Link: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

import java.util.List;

public class Maximum_Twin_Sum_of_a_Linked_List {

    public int pairSum(ListNode head) {
        ListNode revHead = reverseList(copyList(head));
        ListNode current = head;
        ListNode revCurrent = revHead;
        int max = 0;
        int length = 0;

        while (current != null) {
            length++;
            current = current.next;
        }

        current = head;

        while (current != null) {
            int sum = current.val + revCurrent.val;
            if (sum > max) {
                max = sum;
            }

            current = current.next;
            revCurrent = revCurrent.next;
        }

        return max;
    }

    public static ListNode copyList(ListNode head) {
        if (head == null) return head;
        ListNode current = head;
        ListNode newHead = new ListNode(head.val);
        ListNode newCurrent = newHead;

        while (current.next != null) {
            current = current.next;
            newCurrent.next = new ListNode(current.val);
            newCurrent = newCurrent.next;
        }

        return newHead;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next == null ? null : next.next;
        }

        return prev;
    }
}
