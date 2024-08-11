package LeetCode.LinkedList;

/*
    ----------------------------------------------------------------
    | Problem: Delete the Middle Node of a Linked List
    | Link: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Delete_the_Middle_Node_of_a_Linked_List {

    public ListNode deleteMiddle(ListNode head) {
        ListNode middleNode = head, prevNode = head, currentNode = head;
        int index = 0;

        // trivial case
        if (head == null) return null;

        // every time the index of the current node is even, we increment the middle node.
        while (currentNode != null) {
            if (index % 2 == 0 && index != 0) {
                prevNode = middleNode;
                middleNode = middleNode.next;
            }
            currentNode = currentNode.next;
            index++;
        }

        // list consist of single element
        if (prevNode == middleNode && index == 1) {
            return null;
        }

        if (index % 2 == 0) {
            prevNode = middleNode;
            middleNode = middleNode.next;
        }

        // delete middle node
        prevNode.next = middleNode.next;
        return head;
    }
}
