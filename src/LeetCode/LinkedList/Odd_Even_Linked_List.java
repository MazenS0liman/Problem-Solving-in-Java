package LeetCode.LinkedList;

/*
    ----------------------------------------------------------------
    | Problem: Odd Even Linked List
    | Link: https://leetcode.com/problems/odd-even-linked-list
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Odd_Even_Linked_List {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode initialEven = even;

        while (odd.next != null) {
            odd.next = even.next;
            if (odd.next != null) {
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
        }

        odd.next = initialEven;

        return head;
    }

}
