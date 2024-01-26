package LeetCode.LinkedList;

// Solution: Accepted

public class Merge_Two_Sorted_Lists {

    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = {0};
        /* Create Linked Lists */
        ListNode head1 = ListNode.createLinkedList(arr1);
        ListNode head2 = ListNode.createLinkedList(arr2);
        /* Merge two Linked Lists */
        ListNode result = mergeTwoLists(head1, head2);
        /* Display Linked List */
        ListNode.displayLinkedList(result);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode current1 = null;
        ListNode current2 = null;

        if (list1 == null && list2 == null) {
            return null;
        }
        else if (list1 == null) {
            return list2;
        }
        else if (list2 == null) {
            return list1;
        }
        else {
            if (list1.val < list2.val) {
                head.val = list1.val;
                head.next = null;
                current1 = list1.next;
                current2 = list2;
            }
            else {
                head.val = list2.val;
                head.next = null;
                current1 = list1;
                current2 = list2.next;
            }

            ListNode prev = head;

            while(current1 != null && current2 != null) {
                ListNode next = null;

                if (current1.val <= current2.val) {
                    next = new ListNode(current1.val, null);
                    current1 = current1.next;
                }
                else {
                    next = new ListNode(current2.val, null);
                    current2 = current2.next;
                }

                prev.next = next;
                prev = next;
            }

            while (current1 != null) {
                ListNode next = new ListNode(current1.val, null);
                current1 = current1.next;
                prev.next = next;
                prev = next;
            }

            while (current2 != null) {
                ListNode next = new ListNode(current2.val, null);
                current2 = current2.next;
                prev.next = next;
                prev = next;
            }

            return head;
        }
    }
}


