package LeetCode.LinkedList;

/*
    ----------------------------------------------------------------
    | Problem: Reverse Linked List
    | Link: https://leetcode.com/problems/reverse-linked-list
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Reverse_Linked_List {

    public ListNode reverseList(ListNode head) {
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
