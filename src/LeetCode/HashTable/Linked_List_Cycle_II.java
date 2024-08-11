package LeetCode.HashTable;

import LeetCode.LinkedList.ListNode;
import java.util.HashSet;

/*
    ----------------------------------------------------------------
    | Problem: Linked List Cycle II
    | Link: https://leetcode.com/problems/linked-list-cycle-ii
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Linked_List_Cycle_II {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hSet = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            if (hSet.contains(current)) {
                return current;
            }

            hSet.add(current);
            current = current.next;
        }

        return null;
    }
}
