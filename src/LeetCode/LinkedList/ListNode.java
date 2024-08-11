package LeetCode.LinkedList;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void displayLinkedList(ListNode list) {
        if (list == null) {
            System.out.println("Empty list");
        }
        else {
            ListNode current = list;

            while (current != null) {
                if (current.next != null) {
                    System.out.print(current.val + " -> ");
                }
                else {
                    System.out.println(current.val);
                }

                current = current.next;
            }
        }
    }

    public static ListNode createLinkedList(int[] arr) {
        ListNode head = null;

        if (arr.length == 0) {
            return null;
        }
        else {
            head = new ListNode(arr[0], null);
            ListNode prev = head;

            for (int i = 1; i < arr.length; i++) {
                ListNode next = new ListNode(arr[i], null);
                prev.next = next;
                prev = next;
            }

            return head;
        }
    }
}
