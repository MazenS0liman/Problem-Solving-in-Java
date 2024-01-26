package LeetCode.LinkedList;

/*
    ----------------------------------------------------------------
    | Problem: Reorder List
    | Link: https://leetcode.com/problems/reorder-list/
    | Status: Accepted
    ----------------------------------------------------------------
*/

public class Reorder_List {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        /* Create Linked Lists */
        ListNode head = ListNode.createLinkedList(arr);
        /* Reorder Linked Lists */
        reorderList(head);
        /* Display Linked List */
        ListNode.displayLinkedList(head);
    }

    public static void reorderList(ListNode head) {
        // Count number of nodes
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }

        ListNode[] arrayOfPointers = new ListNode[count];
        current = head;
        int i = 0;
        while(current != null) {
            arrayOfPointers[i] = current;
            current = current.next;
            i++;
        }

        i = 0;
        int j = arrayOfPointers.length - 1;
        while(i <= j) {
            if (j - i == 1 || i == j) {
                arrayOfPointers[j].next = null;
                break;
            }
            else {
                arrayOfPointers[j].next = arrayOfPointers[i].next;
                arrayOfPointers[i].next = arrayOfPointers[j];
                i++;
                j--;
            }
        }
    }
}
