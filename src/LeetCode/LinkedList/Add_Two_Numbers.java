package LeetCode.LinkedList;

// Solution: Accepted

public class Add_Two_Numbers {

    public static void main(String[] args) {
        int[] arr1 = {9,9,9,9,9,9,9};
        int[] arr2 = {9,9,9,9};
        /* Create Linked Lists */
        ListNode head1 = ListNode.createLinkedList(arr1);
        ListNode head2 = ListNode.createLinkedList(arr2);
        /* Add two Linked Lists */
        ListNode result = addTwoNumbers(head1, head2);
        /* Display Linked List */
        ListNode.displayLinkedList(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Base Cases
        if (l1 == null && l2 == null) {
            return null;
        }
        else if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else {
            ListNode head = new ListNode();
            ListNode current = head;
            ListNode current1 = l1;
            ListNode current2 = l2;
            int sum = 0;
            int carry = 0;

            while(current1 != null && current2 != null) {
                sum = current1.val + current2.val + carry;
                System.out.println("sum = " + sum);
                if (sum >= 10) {
                    sum = sum % 10;
                    carry = 1;
                }
                else {
                    carry = 0;
                }

                current.val = sum;
                if (current1.next == null && current2.next == null) {
                    if (carry == 1) {
                        current.next = new ListNode(carry, null);
                    }
                    else {
                        current.next = null;
                    }
                }
                else {
                    current.next = new ListNode();
                }
                current = current.next;
                current1 = current1.next;
                current2 = current2.next;
            }

            while(current1 != null) {
                sum = current1.val + carry;
                if (sum >= 10) {
                    sum = sum % 10;
                    carry = 1;
                }
                else {
                    carry = 0;
                }

                current.val = sum;
                if (current1.next == null) {
                    if (carry == 1) {
                        current.next = new ListNode(carry, null);
                    }
                    else {
                        current.next = null;
                    }
                }
                else {
                    current.next = new ListNode();
                }
                current = current.next;
                current1 = current1.next;
            }

            while(current2 != null) {
                sum = current2.val + carry;
                if (sum >= 10) {
                    sum = sum % 10;
                    carry = 1;
                }
                else {
                    carry = 0;
                }

                current.val = sum;
                if (current2.next == null) {
                    if (carry == 1) {
                        current.next = new ListNode(carry, null);
                    }
                    else {
                        current.next = null;
                    }
                }
                else {
                    current.next = new ListNode();
                }
                current = current.next;
                current2 = current2.next;
            }

            return head;
        }
    }
}
