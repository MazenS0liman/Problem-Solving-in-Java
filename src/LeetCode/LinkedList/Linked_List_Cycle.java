package LeetCode.LinkedList;

// Solution: Accepted

public class Linked_List_Cycle {

    public static void main(String[] args) {
        int[] arr = {3,2,0,-4};
        /* Create Linked List */
        ListNode head = ListNode.createLinkedList(arr);
        /* Check Linked List contain Cycle */
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode current1 = head;
        ListNode current2 = head.next;

        while(current2 != null && current2.next != null) {
            if (current2 == current1) {
                return true;
            }

            current1 = current1.next;
            current2 = current2.next.next;
        }

        return false;
    }
}
