package LeetCode.LinkedList;

import java.util.HashSet;

/*
    ----------------------------------------------------------------
    | Problem: Intersection of Two Linked Lists
    | Link: https://leetcode.com/problems/intersection-of-two-linked-lists
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Intersection_of_Two_Linked_Lists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<Object> hSet = new HashSet<>();

        ListNode currentNode = headA;

        while(currentNode != null) {
            hSet.add(currentNode);
            currentNode = currentNode.next;
        }

        currentNode = headB;

        while(currentNode != null) {
            if(hSet.contains(currentNode)) {
                return currentNode;
            }

            currentNode = currentNode.next;
        }

        return null;
    }
}
